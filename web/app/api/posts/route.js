import Post from "@/models/post";
import User from "@/models/user";
import { connectToDB } from "@/utils/database";
import TimeAgo from "javascript-time-ago";
// English.
import en from "javascript-time-ago/locale/en";

TimeAgo.addDefaultLocale(en);

// Create formatter (English).
const ago = new TimeAgo("en-US");

// Get all posts
export const GET = async (request) => {
    try {
        await connectToDB();

        const posts = (await Post.find({})).map((post) => {
            let newPost = {
                ...post._doc,
                timeAgo: ago.format(post.createdAt, "round"), //add timeAgo field to get calculated post time ago;
                username: User.findById(post.author).username,
            };

            return newPost;
        }); //find all objects in the database as no parameters are passed to find()
        request.headers.set("Cache-Control", "no-cache");
        request.revalidateSeconds = 30;
        return new Response(JSON.stringify(posts), {
            status: 200,
            headers: {
                "Content-Type": "application/json",
            },
        });
    } catch (error) {
        const err = {
            message: "Failed to get Posts",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
