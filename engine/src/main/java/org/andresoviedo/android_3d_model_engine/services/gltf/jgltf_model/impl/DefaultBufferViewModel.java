/*
 * www.javagl.de - JglTF
 *
 * Copyright 2015-2017 Marco Hutter - http://www.javagl.de
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

package org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.impl;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.BufferModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.BufferViewModel;
import org.andresoviedo.android_3d_model_engine.services.gltf.jgltf_model.io.Buffers;

/**
 * Implementation of a {@link BufferViewModel}
 */
public final class DefaultBufferViewModel extends AbstractNamedModelElement
    implements BufferViewModel
{
    /**
     * The {@link BufferModel} for this model
     */
    private BufferModel bufferModel;
    
    /**
     * The byte offset
     */
    private int byteOffset;
    
    /**
     * The byte length
     */
    private int byteLength;
    
    /**
     * The byte stride
     */
    private Integer byteStride;
    
    /**
     * The optional target
     */
    private final Integer target;

    /**
     * An optional callback that will be used to perform the
     * substitution of sparse accessor data in the 
     * {@link #getBufferViewData() buffer view data}
     * when it is obtained for the first time. 
     */
    private Consumer<? super ByteBuffer> sparseSubstitutionCallback;
    
    /**
     * Whether the sparse substitution was already applied
     */
    private boolean sparseSubstitutionApplied;
    
    /**
     * Creates a new instance
     * 
     * @param target The optional target
     */
    public DefaultBufferViewModel(Integer target)
    {
        this.byteOffset = 0;
        this.byteLength = 0;
        this.target = target;
    }
    
    /**
     * Set the callback that will perform the substitution of sparse accessor 
     * data in the {@link #getBufferViewData() buffer view data} when it is 
     * obtained for the first time.
     *  
     * @param sparseSubstitutionCallback The callback
     */
    public void setSparseSubstitutionCallback(
        Consumer<? super ByteBuffer> sparseSubstitutionCallback)
    {
        this.sparseSubstitutionCallback = sparseSubstitutionCallback;
    }
    
    /**
     * Set the {@link BufferModel} for this model
     * 
     * @param bufferModel The {@link BufferModel}
     */
    public void setBufferModel(BufferModel bufferModel)
    {
        this.bufferModel = bufferModel;
    }
    
    /**
     * Set the byte offset of this view referring to its {@link BufferModel}
     *  
     * @param byteOffset The byte offset
     */
    public void setByteOffset(int byteOffset)
    {
        this.byteOffset = byteOffset;
    }

    /**
     * Set the byte length of this buffer view
     * 
     * @param byteLength The byte length
     */
    public void setByteLength(int byteLength)
    {
        this.byteLength = byteLength;
    }

    /**
     * Set the optional byte stride. This byte stride must be 
     * non-<code>null</code> if more than one accessor refers
     * to this buffer view.
     *  
     * @param byteStride The byte stride
     */
    public void setByteStride(Integer byteStride)
    {
        this.byteStride = byteStride;
    }
    
    
    @Override
    public ByteBuffer getBufferViewData()
    {
        ByteBuffer bufferData = bufferModel.getBufferData();
        ByteBuffer bufferViewData = 
            Buffers.createSlice(bufferData, getByteOffset(), getByteLength());
        if (sparseSubstitutionCallback != null && !sparseSubstitutionApplied)
        {
            sparseSubstitutionCallback.accept(bufferViewData);
            sparseSubstitutionApplied = true;
        }
        return bufferViewData;
    }

    @Override
    public BufferModel getBufferModel()
    {
        return bufferModel;
    }

    @Override
    public int getByteOffset()
    {
        return byteOffset;
    }

    @Override
    public int getByteLength()
    {
        return byteLength;
    }

    @Override
    public Integer getByteStride()
    {
        return byteStride;
    }

    @Override
    public Integer getTarget()
    {
        return target;
    }

}