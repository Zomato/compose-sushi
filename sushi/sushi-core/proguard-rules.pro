# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-repackageclasses com.zomato.sushilib-core
#
## Keep the SushiColorToken interface
-keep interface com.zomato.sushi.core.SushiColorToken { *; }
#
## Keep the SushiColorToken factory function
#-keepclassmembers class com.zomato.sushi.core.SushiColorTokenKt {
#    public static ** SushiColorToken(java.lang.String);
#}
#
## Keep anonymous implementations of SushiColorToken created via the factory function
#-keep class * implements com.zomato.sushi.core.SushiColorToken
#
## If you're using reflection to access token property
#-keepclassmembernames class * implements com.zomato.sushi.core.SushiColorToken {
#    java.lang.String getToken();
#}
