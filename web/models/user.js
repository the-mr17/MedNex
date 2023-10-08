import { Schema, model, models } from "mongoose";

const UserSchema = new Schema({
    email: {
        type: String,
        unique: [true, "\nEmail already exists!"],
        required: [true, "\nEmail is required!"],
    },
    fullname: {
        type: String,
        required: [true, "\nFull name is required!"],
    },
    username: {
        type: String,
        required: [true, "\nUsername is required!"],
        match: [
            /^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$/,
            "\nUsername invalid, it should contain 8-20 alphanumeric characters!",
        ],
        unique: [true, "\nusername already exists!"],
    },
    category: {
        type: String,
        required: [true, "\nPlease select Patient/Doctor"],
    },
    userimage: {
        type: String,
    },
});

const User = models.User || model("User", UserSchema);

export default User;
