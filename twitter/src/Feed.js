import React, { useState, useEffect } from "react";
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';


const Feed = () => {

    const [postData, setPostData] = useState(null);
    const endpoint = 'http://51.20.128.84:8080/posts';

    useEffect(()=> {
        const fetchPosts = async() => {
            try {
                setPostData(
                    await fetch(endpoint)
                    .then((response) => response.json())
                )
            } catch(error){
                console.log("Some Error occured when fetching posts")
            }
        };
        fetchPosts();
    },[]);
    
    const handleSubmit = (event) =>{
        console.log("Submit button pressed SUCCESSFULLY")
        // event.preventDefault();
        // fetch('http://51.20.128.84:8080/post',{
        //     method: 'post',
        //     headers: {'Content-Type':'application/json'},
        //     body: JSON.stringify({
        //         "title": "New Post",
        //         "userName": "Master_Bobba",
        //         "content": document.querySelector('#newPost').value
        //         // "content": "Hi There  <img onerror=alert(''Congratulations_You_Hacked_Yourself''); src=invalid-image/>"
        //     })
        // });
        // document.querySelector('#newPost').value = "";
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div class="form-group">
                    <label for="exampleInputPassword1"><b> NEW POST </b></label>
                    <input type="text" class="form-control" id="newPost" placeholder="New Post Content..."/>
                </div>
                    <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
            {postData ? (
                <div>                
                    <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                    {postData.map((post) => (
                        <div>
                            <ListItem alignItems="flex-start">
                            <ListItemAvatar>
                                <Avatar alt={post.userName} src="/static/images/avatar/1.jpg" />
                            </ListItemAvatar>
                            <ListItemText
                                primary= {post.title} by
                                secondary={
                                    <React.Fragment>
                                    <Typography
                                        sx={{ display: 'inline' }}
                                        component="span"
                                        variant="body2"
                                        color="text.primary"
                                    >
                                        {/* {post.userName} */}
                                    </Typography>
                                    <div dangerouslySetInnerHTML={{"__html":post.content}}></div>
                                    </React.Fragment>
                                }
                                />
                            </ListItem>
                            <Divider variant="inset" component="li" />
                        </div>  
                    ))}
                </List>
            </div>
            ): (
                <div>
                    Loading content...
                </div>
                
            )}
        </div>
    );
};

export default Feed;