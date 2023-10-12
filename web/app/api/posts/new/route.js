import Post from "@/models/post";
import { connectToDB } from "@/utils/database"; //Function for connecting to Db

export const POST = async (request) => {
    const { text, author, createdAt, parentId, children } =
        await request.json(); // get the data from the body of the request

    try {
        await connectToDB();
        const newPost = new Post({
            text: text,
            author: author,
            createdAt: createdAt,
            parentId: parentId,
            children: children,
        });

        await newPost.save();

        //If parentId data is passed then add the id of the current post to the children of the parent post;
        if (parentId) {
            const parentPost = await Post.findById(parentId);
            parentPost.children.push(newPost._id);
            console.log(parentPost.children);
            await parentPost.save();
        }

        return new Response(JSON.stringify(newPost), {
            status: 201,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to create Post", //Generic error message
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
