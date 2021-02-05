/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.beerapiproducerjaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.beerapiproducerjaxrs.model.FraudCheck;
import com.example.beerapiproducerjaxrs.model.FraudCheckResult;


import static com.example.beerapiproducerjaxrs.model.FraudCheckStatus.NOT_OK;
import static com.example.beerapiproducerjaxrs.model.FraudCheckStatus.OK;

@Path("/")
public class FraudDetectionController {

	@POST
	@Path("/check")
	@Produces("application/json;charset=utf-8")
	@Consumes("application/json;charset=utf-8")
	public FraudCheckResult fraudCheck(FraudCheck fraudCheck) {
		if (tooYoung(fraudCheck)) {
			return new FraudCheckResult(NOT_OK);
		}
		return new FraudCheckResult(OK);
	}

	@GET
	@Path("/check")
	public FraudCheckResult fraudCheck() {

		return new FraudCheckResult(OK);
	}

	private boolean tooYoung(FraudCheck fraudCheck) {
		return fraudCheck.getAge() < 20;
	}

}
