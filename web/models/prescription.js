const { Schema, model, models } = require("mongoose");

// Prescription Structure
const prescriptionSchema = new Schema({
    doctorName: {
        type: String,
        required: true,
    },
    medication: {
        type: [String], //Array of strings; Each medication to be formatted correctly through frontend
    },
    tests: {
        type: [String], //Array of strings
    },
});

const prescription =
    models.prescription || model("prescription", prescriptionSchema);

export default prescription;
