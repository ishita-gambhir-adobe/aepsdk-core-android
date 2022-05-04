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
package com.adobe.marketing.mobile.utility

import com.adobe.marketing.mobile.services.utility.FileUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class FileUtilTests {

    @Test
    fun testRemoveRelativePath_RelativePathBackslashClearnedUp() {
        assertEquals(FileUtil.removeRelativePath("/mydatabase\\..\\..\\database1"), "mydatabase_database1")
    }

    @Test
    fun testRemoveRelativePath_RelativePathForwardslashClearnedUp() {
        assertEquals(FileUtil.removeRelativePath("/mydatabase/../../database1"), "mydatabase_database1")
    }

    @Test
    fun testRemoveRelativePath_RelativePathBackslashDoesNotChangeDir() {
        assertEquals(FileUtil.removeRelativePath("/mydatabase\\..\\database1"), "mydatabase_database1")
    }

    @Test
    fun testRemoveRelativePath_RelativePathForwardslashDoesNotChangeDir() {
        assertEquals(FileUtil.removeRelativePath("/mydatabase/../database1"), "mydatabase_database1")
    }
}
