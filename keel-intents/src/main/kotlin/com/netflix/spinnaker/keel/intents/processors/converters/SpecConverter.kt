/*
 * Copyright 2017 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spinnaker.keel.intents.processors.converters

import com.netflix.spinnaker.keel.IntentSpec

interface SpecConverter<I : IntentSpec, S : Any> {

  fun convertToState(spec: I): S
  fun convertFromState(state: S): I?
  fun convertToJob(spec: I): MutableMap<String, Any?>
}

const val COMPUTED_VALUE = "<computed>"