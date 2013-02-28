/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.filtershow.editors;

import android.content.Context;
import android.widget.FrameLayout;

import com.android.gallery3d.R;
import com.android.gallery3d.filtershow.imageshow.ImageFlip;
import com.android.gallery3d.filtershow.imageshow.MasterImage;

public class EditorFlip extends Editor implements EditorInfo {
    public static final int ID = R.id.editorFlip;
    ImageFlip mImageFlip;

    public EditorFlip() {
        super(ID);
    }

    @Override
    public void createEditor(Context context, FrameLayout frameLayout) {
        super.createEditor(context, frameLayout);
        if (mImageFlip == null) {
            mImageFlip = new ImageFlip(context);
        }
        mView = mImageShow = mImageFlip;
        mImageFlip.setImageLoader(MasterImage.getImage().getImageLoader());
        mImageFlip.setEditor(this);
        mImageFlip.syncLocalToMasterGeometry();
    }

    @Override
    public int getTextId() {
        return R.string.mirror;
    }

    @Override
    public int getOverlayId() {
        return R.drawable.filtershow_button_geometry_flip;
    }

    @Override
    public boolean getOverlayOnly() {
        return true;
    }
}
