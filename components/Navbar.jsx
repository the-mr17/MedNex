"use client";

import React from "react";

import {
    Navbar,
    NavbarBrand,
    NavbarContent,
    NavbarItem,
    Link,
    Button,
} from "@nextui-org/react";
import { MedNexLogo } from "./MedNexLogo.jsx";

export default function NavBar() {
    return (
        <Navbar shouldHideOnScroll isBordered>
            <NavbarBrand>
                <MedNexLogo />
                <p className="font-bold text-inherit">MedNex</p>
            </NavbarBrand>
            <NavbarContent className="hidden sm:flex gap-4" justify="center">
                <NavbarItem isActive>
                    <Button
                        href="#"
                        as={Link}
                        color="primary"
                        variant="solid"
                    >
                        Locate Clinics
                    </Button>
                </NavbarItem>
                <NavbarItem>
                    <Button
                        href="#"
                        as={Link}
                        color="primary"
                        variant="transparent"
                    >
                        Treat Me
                    </Button>
                </NavbarItem>
                <NavbarItem>
                    <Button
                        href="#"
                        as={Link}
                        color="primary"
                        variant="transparent"
                    >
                        Insure Me
                    </Button>
                </NavbarItem>
                <NavbarItem>
                    <Button
                        href="#"
                        as={Link}
                        color="primary"
                        variant="transparent"
                    >
                        Government
                    </Button>
                </NavbarItem>
                <NavbarItem>
                    <Button
                        href="#"
                        as={Link}
                        color="primary"
                        variant="transparent"
                    >
                        Community
                    </Button>
                </NavbarItem>
            </NavbarContent>
            <NavbarContent justify="end">
                <NavbarItem className="hidden lg:flex">
                    <Link href="#">Login</Link>
                </NavbarItem>
                <NavbarItem>
                    <Button as={Link} color="primary" href="#" variant="flat">
                        Sign Up
                    </Button>
                </NavbarItem>
            </NavbarContent>
        </Navbar>
    );
}
