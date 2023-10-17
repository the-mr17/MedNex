import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
    title: "MedNex",
    description: "Connect to your health guide",
    icon: "assets/favicon-32x32.png",
    favicon: "favicon.ico",
};

import NavBar from "@/components/Navbar";
import Footer from "@/components/Footer";

export default function RootLayout({ children }) {
    return (
        <html lang="en" className="dark">
            <body className=" min-h-screen bg-neutral-900 p-0 text-gray-300">
                <NavBar />
                {children}
                <Footer />
            </body>
        </html>
    );
}
