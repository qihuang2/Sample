package com.android.rnm.bustime.converters;

public interface Converter <S, T> {

    T convert(S input);
}
