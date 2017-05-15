package ua.ho.andro.marvelapp.helper;

import android.support.annotation.NonNull;

public interface Callback<T> {
    void onSuccess(@NonNull T result);

    void onError();
}