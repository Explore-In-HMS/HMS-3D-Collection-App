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

package org.andresoviedo.android_3d_model_engine.services.collada.entities;

import java.util.ArrayList;
import java.util.List;

public class KeyFrameData {

	public final float time;
	public final List<JointTransformData> jointTransforms = new ArrayList<>();
	
	public KeyFrameData(float time){
		this.time = time;
	}
	
	public void addJointTransform(JointTransformData transform){
		jointTransforms.add(transform);
	}
	
}