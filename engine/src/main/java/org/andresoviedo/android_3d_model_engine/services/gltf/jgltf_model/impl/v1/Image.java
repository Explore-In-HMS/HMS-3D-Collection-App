/*
 * glTF JSON model
 * 
 * Do not modify this class. It is automatically generated
 * with JsonModelGen (https://github.com/javagl/JsonModelGen)
 * Copyright (c) 2016 Marco Hutter - http://www.javagl.de
 */

// Copyright 2020. Explore in HMS. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1;



/**
 * Image data used to create a texture. 
 * 
 * Auto-generated for image.schema.json 
 * 
 */
public class Image
    extends GlTFChildOfRootProperty
{

    /**
     * The uri of the image. (required) 
     * 
     */
    private String uri;

    /**
     * The uri of the image. (required) 
     * 
     * @param uri The uri to set
     * @throws NullPointerException If the given value is <code>null</code>
     * 
     */
    public void setUri(String uri) {
        if (uri == null) {
            throw new NullPointerException((("Invalid value for uri: "+ uri)+", may not be null"));
        }
        this.uri = uri;
    }

    /**
     * The uri of the image. (required) 
     * 
     * @return The uri
     * 
     */
    public String getUri() {
        return this.uri;
    }

}
