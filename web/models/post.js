import mongoose from "mongoose";

const postSchema = new mongoose.Schema({
    text: {
        type: String,
        required: [true, "Post is required"],
    },
    author: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "User",
        required: true,
    },
    createdAt: {
        type: Date,
        default: Date.now,
    },
    parentId: {
        type: String,
    },
    likeCount: {
        type: Number,
        default: 0,
    },
    children: [
        {
            type: mongoose.Schema.Types.ObjectId,
            ref: "Post",
        },
    ],
});

const Post = mongoose.models.Post || mongoose.model("Post", postSchema);

export default Post;
