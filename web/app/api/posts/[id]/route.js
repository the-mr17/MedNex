import Post from "@/models/post";
import { connectToDB } from "@/utils/database";

export const GET = async (req, { params }) => {
    try {
        await connectToDB();
        const post = await Post.findById(params.id);

        return new Response(JSON.stringify(post), { status: 200 });
    } catch (error) {
        return new Response("Failed to get Post", { status: 500 });
    }
};
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated post info from the request body
        const updates = await req.json();

        const post = await Post.findByIdAndUpdate(params.id, updates, {
            new: true,
        });

        return new Response(JSON.stringify(post));
    } catch (error) {
        return new Response("Failed to update Post " + error, { status: 500 });
    }
};
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();
        const post = await Post.findByIdAndDelete(params.id);
        return new Response(`Post ${params.id} was deleted`, { status: 200 });
    } catch (error) {
        return new Response("Failed to delete Post", { status: 500 });
    }
};
