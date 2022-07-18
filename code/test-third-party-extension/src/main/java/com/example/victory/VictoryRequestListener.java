/*
  Copyright 2022 Adobe. All rights reserved.
  This file is licensed to you under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software distributed under
  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
  OF ANY KIND, either express or implied. See the License for the specific language
  governing permissions and limitations under the License.
 */

package com.example.victory;

import com.adobe.marketing.mobile.Event;
import com.adobe.marketing.mobile.ExtensionApi;
import com.adobe.marketing.mobile.ExtensionListener;

import java.util.Map;

class VictoryRequestListener extends ExtensionListener {

	protected VictoryRequestListener(final ExtensionApi extension, final String type, final String source) {
		super(extension, type, source);
	}

	@Override
	public void hear(Event event) {
		Map<String, Object> eventData = event.getEventData();

		if (eventData != null && eventData.containsKey(VictoryConstants.UNREGISTER_EXTENSION)) {
			getParentExtension().getApi().unregisterExtension();
		} else {
			getParentExtension().addEvent(event);
			getParentExtension().processEvents();
		}
	}

	@Override
	protected VictoryExtension getParentExtension() {
		return (VictoryExtension)super.getParentExtension();
	}
}