/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2016 Marco Hutter - http://www.javagl.de
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.v1.gl;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1.Material;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1.Program;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl.v1.Shader;

/**
 * Utility methods for {@link Program}s
 */
class Programs
{
    /**
     * Creates a default {@link Program} with the given vertex- and 
     * fragment {@link Shader} IDs, which are assumed to refer to
     * the {@link Shaders#createDefaultVertexShader() default vertex shader}
     * and {@link Shaders#createDefaultFragmentShader() default fragment 
     * shader}.<br>
     * <br>
     * The returned {@link Program} is the {@link Program} for the default 
     * {@link Material}, as described in "Appendix A" of the 
     * glTF 1.0 specification. 
     * 
     * @param vertexShaderId The vertex {@link Shader} ID
     * @param fragmentShaderId The fragment {@link Shader} ID
     * @return The default {@link Program}
     */
    static Program createDefaultProgram(
        String vertexShaderId, String fragmentShaderId)
    {
        Program program = new Program();
        program.setVertexShader(vertexShaderId);
        program.setFragmentShader(fragmentShaderId);
        program.addAttributes("a_position");
        return program;
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private Programs()
    {
        // Private constructor to prevent instantiation
    }

}
