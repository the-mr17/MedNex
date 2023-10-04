import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
    title: "MedNex",
    description: "Connect to your health guide",
    icon: "assets/favicon-32x32.png",
    favicon: "favicon.ico",
};

// app/layout.tsx
import { Providers } from "./providers";
import NavBar from "@/components/Navbar";
import Footer from "@/components/Footer";

export default function RootLayout({ children }) {
    return (
        <html lang="en" className="dark">
            <body>
                <Providers>
                    <NavBar />
                    {children}
                    <Footer />
                </Providers>
            </body>
        </html>
    );
}
