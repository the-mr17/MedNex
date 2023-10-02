"use client";

import React from "react";
import { MedNexLogo } from "./MedNexLogo.jsx";
import styled from "styled-components"
import { FaDiscord, FaInstagram, FaYoutube } from "react-icons/fa";

const Wrapper = styled.section``;

export default function Footer() {
    return <Wrapper>
        <footer>
        <div className="container grid grid-four-column">
          <div className="footer-about">
            <MedNexLogo />
            <h3>MedNex</h3>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.</p>
          </div>

          {/* 2nd column */}
          <div className="footer-subscribe">
            <h3>Subscribe to get important updates</h3>
            <form action="#">
              <input
                type="email"
                required
                autoComplete="off"
                placeholder="Email"
              />
              <input type="submit" value="Subscribe" />
            </form>
          </div>

          {/* 3rs column  */}
          <div className="footer-social">
            <h3>Follows Us</h3>
            <div className="footer-social--icons">
              <div>
              <a
                  href="https://www.discord.com"
                  target="_blank">
                  <FaDiscord className="icons" />
                </a>
              </div>
              <div>
              <a
                  href="https://www.instagram.com"
                  target="_blank">
                  <FaInstagram className="icons" />
                </a>
              </div>
              <div>
                <a
                  href="https://www.youtube.com"
                  target="_blank">
                  <FaYoutube className="icons" />
                </a>
              </div>
            </div>
          </div>

          {/* 4th column  */}
          <div className="footer-contact">
            <h3>Call Us</h3>
            <h3>+91 1234567890</h3>
          </div>
        </div>

        {/* bottom section  */}
        <div className="footer-bottom--section">
          <hr />
          <div className="container grid grid-two-column">
            <p>
              @{new Date().getFullYear()} MedNex. All Rights Reserved
            </p>
            <div>
              <p>PRIVACY POLICY</p>
              <p>TERMS & CONDITIONS</p>
            </div>
          </div>
        </div>
      </footer>
    </Wrapper>
}
