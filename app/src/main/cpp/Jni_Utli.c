//
// Created by OzoraTsubasa on 2018/12/7.
//
#include <string.h>
#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_test_studio_JniUtli_sayHellow
 ( JNIEnv* env, jclass cls)
{
  return (*env)->NewStringUTF(env, "Hello from JNI !");
}

