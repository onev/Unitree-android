#include <jni.h>
#include <string>

uint32_t CRC32(uint32_t *ptr, uint32_t len);

extern "C" JNIEXPORT jint

JNICALL
Java_com_lt_unitreetest_sdk_CRCUtil_getCRC
        (JNIEnv *env, jobject /* this */, jintArray arr) {

    jint i = 0;
    jint *c_array;
    jint arr_len;
    //1. 获取数组长度
    arr_len = env->GetArrayLength(arr);
    //2. 根据数组长度和数组元素的数据类型申请存放java数组元素的缓冲区
    c_array = (jint *) malloc(sizeof(jint) * arr_len);
    //3. 初始化缓冲区
    memset(c_array, 0, sizeof(jint) * arr_len);
    printf("arr_len = %d ", arr_len);
    //4. 拷贝Java数组中的所有元素到缓冲区中
    (env)->GetIntArrayRegion(arr, 0, arr_len, c_array);


    uint8_t data[arr_len];


    for (i = 0; i < arr_len; i++) {
        data[i] = c_array[i];
    }
    free(c_array);  //6. 释放存储数组元素的缓冲区


    uint32_t crc = CRC32((uint32_t *) data, sizeof(data) >> 2);
    std::string crcstr = std::to_string(crc);

//    return env->NewStringUTF(crcstr.c_str());
    return crc;

}

uint32_t CRC32(uint32_t *ptr, uint32_t len) {
    uint32_t xbit;
    uint32_t data;
    uint32_t CRC32 = 0xFFFFFFFF;
    uint32_t bits;
    const uint32_t dwPolynomial = 0x04c11db7;

    for (uint32_t i = 0; i < len; i++) {
        xbit = (uint32_t) 1 << 31;
        data = ptr[i];
        for (bits = 0; bits < 32; bits++) {
            if (CRC32 & 0x80000000) {
                CRC32 <<= 1;
                CRC32 ^= dwPolynomial;
            } else
                CRC32 <<= 1;

            if (data & xbit)
                CRC32 ^= dwPolynomial;

            xbit >>= 1;
        }
    }

    return CRC32;
}

