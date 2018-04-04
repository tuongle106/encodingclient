/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.sample.login.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class APIController {
    private static final String JSON_APPLICATION = "application/x-www-form-urlencoded";
    private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @PostMapping(value = "media/callback/notify", consumes = "text/html")
    public void notifyCallback(@RequestBody String json) {
        LOGGER.info("notifyCallback: {}", json);
    }

    @PostMapping(value = "media/callback/error")
    public void notifyCallbackError(@RequestBody Object json) {
        LOGGER.info("notifyCallbackError: {}", json);
    }

    @PostMapping(value = "media/callback/upload", consumes = "text/html")
    public void notifyCallbackUpload(@RequestBody String json) {
        LOGGER.info("notifyCallbackUpload: {}", json);
    }

    public static void main(String[] args) {
        String encoded = "%7B%22result%22%3A%7B%22mediaid%22%3A%22166112948%22%2C%22source%22%3A%22https%3A%5C%2F%5C%2Fvamvideos.s3.amazonaws.com%5C%2F2018%5C%2F02%5C%2F06%5C%2Fstep.mov%22%2C%22status%22%3A%22Error%22%2C%22description%22%3A%22No+tasks+are+completed%22%2C%22encodinghost%22%3A%22http%3A%5C%2F%5C%2Fmanage.encoding.com%5C%2F%22%2C%22format%22%3A%7B%22taskid%22%3A%22572462435%22%2C%22output%22%3A%22advanced_hls%22%2C%22status%22%3A%22Error%22%2C%22description%22%3A%22ECOM00269%3A+Audio+extraction+failed%22%2C%22suggestion%22%3A%22Our+decoder+could+not+extract+audio+stream+from+your+source+file.+%22%7D%7D%7D";
        String s2 = null;
        try {
            s2 = new String(encoded.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.print("S2: " + s2);
    }
}
