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
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    String JSON_APPLICATION = "application/json";
    private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @RequestMapping(value ="media/callback/notify", consumes = JSON_APPLICATION, produces = JSON_APPLICATION)
    public ResponseEntity notifyCallback(@RequestBody RequestEntity notifyRequest) {
        LOGGER.info("notifyCallback: {}", notifyRequest);
        return null;
    }

    @RequestMapping(value ="media/callback/error", consumes = JSON_APPLICATION, produces = JSON_APPLICATION)
    public ResponseEntity notifyCallbackError(@RequestBody RequestEntity notifyRequest) {
        LOGGER.info("notifyCallbackError: {}", notifyRequest);
        return null;
    }

    @RequestMapping(value ="media/callback/upload", consumes = JSON_APPLICATION, produces = JSON_APPLICATION)
    public ResponseEntity notifyCallbackUpload(@RequestBody RequestEntity notifyRequest) {
        LOGGER.info("notifyCallbackUpload: {}", notifyRequest);
        return null;
    }

}
