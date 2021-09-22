/*
 * Copyright (C) 2021 Huawei Device Co., Ltd.
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
package com.tv.danmaku.ijk.utils;

import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.PixelMapElement;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.element.VectorElement;
import ohos.agp.render.Arc;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.global.resource.*;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

public class ResTUtil {
    private static final String TAG = ResTUtil.class.getSimpleName();

    private static final String CITY_ID_ATTR = "cityId_";

    private static final String STRING_ID_ATTR = "String_";
    /**
     * the half value
     */
    public static final float FLOAT_HALF = 0.5f;

    private ResTUtil() {
        LogUtils.info(TAG, "Entering ResUtil()");
    }


    /**
     * get the path from id
     *
     * @param context the context
     * @param id      the id
     * @return the path from id
     */
    public static String getPathById(Context context, int id) {
        LogUtils.info(TAG, "Entering getPathById");
        String path = "";
        if (context == null) {
            LogUtils.e(TAG, "getPathById -> get null context");
            return path;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getPathById -> get null ResourceManager");
            return path;
        }
        try {
            path = manager.getMediaPath(id);
        } catch (IOException e) {
            LogUtils.e(TAG, "getPathById -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getPathById -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getPathById -> WrongTypeException");
        }
        return path;
    }

    /**
     * get the new color
     *
     * @param context the context
     * @param id      the id
     * @return the color
     */
    public static Color getNewColor(Context context, int id) {
        LogUtils.info(TAG, "Entering getNewColor");
        Color result = new Color(getColor(context, id));
        return result;
    }

    /**
     * get the color
     *
     * @param context the context
     * @param id      the id
     * @return the color
     */
    public static int getColor(Context context, int id) {
        LogUtils.info(TAG, "Entering getColor");
        int result = 0;
        if (context == null) {
            LogUtils.e(TAG, "getColor -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getColor -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getColor();
        } catch (IOException e) {
            LogUtils.e(TAG, "getColor -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getColor -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getColor -> WrongTypeException");
        }
        return result;
    }

    /**
     * get the dimen value
     *
     * @param context the context
     * @param id      the id
     * @return get the float dimen value
     */
    public static float getDimen(Context context, int id) {
        LogUtils.info(TAG, "Entering getDimen");
        float result = 0;
        if (context == null) {
            LogUtils.e(TAG, "getDimen -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getDimen -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getFloat();
        } catch (IOException e) {
            LogUtils.e(TAG, "getDimen -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getDimen -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getDimen -> WrongTypeException");
        }
        return result;
    }


    /**
     * get the dimen value
     *
     * @param context the context
     * @param id      the id
     * @return get the int dimen value
     */
    public static int getIntDimen(Context context, int id) {
        LogUtils.info(TAG, "Entering getIntDimen");
        float value = getDimen(context, id);
        return (int) (value >= 0 ? value + FLOAT_HALF : value - FLOAT_HALF);
    }

    /**
     * get string
     *
     * @param context the context
     * @param id      the string id
     * @return string of the given id
     */
    public static String getString(Context context, int id) {
        LogUtils.info(TAG, "Entering getString");
        String result = "";
        if (context == null) {
            LogUtils.e(TAG, "getString -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getString -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getString();
        } catch (IOException e) {
            LogUtils.e(TAG, "getString -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getString -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getString -> WrongTypeException");
        }
        return result;
    }

    /**
     * get boolean
     *
     * @param context the context
     * @param id      the boolean id
     * @return boolean of the given id
     */
    public static boolean getBoolean(Context context, int id) {
        LogUtils.info(TAG, "Entering getBoolean");
        boolean result = false;
        if (context == null) {
            LogUtils.e(TAG, "getBoolean -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getBoolean -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getBoolean();
        } catch (IOException e) {
            LogUtils.e(TAG, "getBoolean -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getBoolean -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getBoolean -> WrongTypeException");
        }
        return result;
    }

    /**
     * get the string array
     *
     * @param context the context
     * @param id      the string array id
     * @return the string array
     */
    public static String[] getStringArray(Context context, int id) {
        LogUtils.info(TAG, "Entering getStringArray");
        String[] result = null;
        if (context == null) {
            LogUtils.e(TAG, "getStringArray -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getStringArray -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getStringArray();
        } catch (IOException e) {
            LogUtils.e(TAG, "getStringArray -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getStringArray -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getStringArray -> WrongTypeException");
        }
        return result;
    }

    /**
     * get the int array
     *
     * @param context the context
     * @param id      the int array
     * @return the int array
     */
    public static int[] getIntArray(Context context, int id) {
        LogUtils.info(TAG, "Entering getIntArray");
        int[] result = null;
        if (context == null) {
            LogUtils.e(TAG, "getIntArray -> get null context");
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            LogUtils.e(TAG, "getIntArray -> get null ResourceManager");
            return result;
        }
        try {
            result = manager.getElement(id).getIntArray();
        } catch (IOException e) {
            LogUtils.e(TAG, "getIntArray -> IOException");
        } catch (NotExistException e) {
            LogUtils.e(TAG, "getIntArray -> NotExistException");
        } catch (WrongTypeException e) {
            LogUtils.e(TAG, "getIntArray -> WrongTypeException");
        }
        return result;
    }

    /**
     * get the vector drawable
     *
     * @param context the context
     * @param id      the drawable id
     * @return the vector drawable
     */
    public static VectorElement getVectorDrawable(Context context, int id) {
        LogUtils.info(TAG, "Entering getVectorDrawable");
        if (context == null) {
            LogUtils.e(TAG, "getVectorDrawable -> get null context");
            return null;
        }
        return new VectorElement(context, id);
    }

    /**
     * get the pixel map
     *
     * @param context the context
     * @param id      the id
     * @return the pixel map
     */
    public static Optional<PixelMap> getPixelMap(Context context, int id) {
        LogUtils.info(TAG, "Entering getPixelMap");
        String path = getPathById(context, id);
        if (TextUtils.isEmpty(path)) {
            LogUtils.e(TAG, "getPixelMap -> get empty path");
            return Optional.empty();
        }
        RawFileEntry assetManager = context.getResourceManager().getRawFileEntry(path);
        ImageSource.SourceOptions options = new ImageSource.SourceOptions();
        options.formatHint = "image/png";
        ImageSource.DecodingOptions decodingOptions = new ImageSource.DecodingOptions();
        try {
            Resource asset = assetManager.openRawFile();
            ImageSource source = ImageSource.create(asset, options);
            return Optional.ofNullable(source.createPixelmap(decodingOptions));
        } catch (IOException e) {
            LogUtils.e(TAG, "getPixelMap -> IOException");
        }
        return Optional.empty();
    }

    /**
     * get the Pixel Map Element
     *
     * @param context the context
     * @param resId   the res id
     * @return the Pixel Map Element
     */
    public static PixelMapElement getPixelMapDrawable(Context context, int resId) {
        LogUtils.info(TAG, "Entering getPixelMapDrawable");
        Optional<PixelMap> optional = getPixelMap(context, resId);
        return optional.map(PixelMapElement::new).orElse(null);
    }

    /**
     * get the Element
     *
     * @param color the color
     * @return the Element
     */
    public static Element buildDrawableByColor(int color) {
        LogUtils.info(TAG, "Entering buildDrawableByColor");
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.RECTANGLE);
        drawable.setRgbColor(RgbColor.fromArgbInt(color));
        return drawable;
    }

    /**
     * get the Element By ColorRadius
     *
     * @param color  the color
     * @param radius the radius
     * @return the Element By ColorRadius
     */
    public static Element buildDrawableByColorRadius(int color, float radius) {
        LogUtils.info(TAG, "Entering buildDrawableByColorRadius");
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.RECTANGLE);
        drawable.setRgbColor(RgbColor.fromArgbInt(color));
        drawable.setCornerRadius(radius);
        return drawable;
    }

    /**
     * get the ShapeElement
     *
     * @param thickness  the thickness
     * @param inside     the inside color
     * @param border     the border color
     * @param startAngle the start angle
     * @param sweepAngle the sweep angle
     * @return the ShapeElement
     */
    public static ShapeElement getCustomArcGradientDrawable(int thickness, Color inside, Color border, float startAngle,
                                                            float sweepAngle) {
        LogUtils.info(TAG, "Entering getCustomArcGradientDrawable");
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.ARC);
        drawable.setRgbColor(RgbColor.fromArgbInt(inside.getValue())); // keep it transparent for main(inner) part
        drawable.setArc(new Arc(startAngle, sweepAngle, false));
        drawable.setStroke(thickness, RgbColor.fromArgbInt(border.getValue()));
        return drawable;
    }

    /**
     * get res id by reflect
     *
     * @param resClass res class
     * @param resName  res name
     * @return res id
     */
    public static OptionalInt getResIdByReflect(Class resClass, String resName) {
        LogUtils.info(TAG, "Entering getResIdByReflect");
        return null;
    }

    /**
     * get native city name
     *
     * @param context the context
     * @param cityId  cityId
     * @return city name from cityId
     */
    public static String getNativeCityName(Context context, String cityId) {
        LogUtils.info(TAG, "Entering getNativeCityName");
        return null;
    }

    /**
     * find view by id
     *
     * @param view rootView
     * @param id   res id
     * @param <T>  type
     * @return view
     */
    public static <T extends Component> T findViewById(Component view, int id) {
        LogUtils.info(TAG, "Entering findViewById");
        if (view == null) {
            return null;
        }
        return (T) view.findComponentById(id);
    }
}

