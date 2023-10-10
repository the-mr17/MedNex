import Post from "@/models/post";
import { connectToDB } from "@/utils/database"; //function for connecting to mongodb

// Handle Get request for post with the ObjectId of the post passed into the params
// e.g.- {{base_url}}/api/posts/12345  Method: GET
export const GET = async (req, { params }) => {
    try {
        await connectToDB();
        const post = await Post.findById(params.id); //Get post by id

        return new Response(JSON.stringify(post), { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to get Post", //generic error message
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};

// Handle PUT requests for post with the ObjectId of the post passed into the params
// e.g.-
//
// {{base_url}}/api/posts/12345
// Method: PUT
// Body:{
//     "text":"updated text"
// }
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated post info from the request body
        const updates = await req.json();
        // Find the post by Id and update the data of the post with the body of the request
        const post = await Post.findByIdAndUpdate(params.id, updates, {
            new: true,
        });

        return new Response(JSON.stringify(post));
    } catch (error) {
        const err = {
            message: "Failed to update Post", //generic error message
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};

// Handle DELETE request for post with the ObjectId of the post passed into the params
// e.g.- {{base_url}}/api/posts/12345  Method: DELETE
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();
        // Find post with the Id in mongodb and delete the post
        const post = await Post.findByIdAndDelete(params.id);
        return new Response(`Post ${params.id} was deleted`, { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to Delete Post", //Generic error Message
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
