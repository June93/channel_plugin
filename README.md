# channel_plugin

A Flutter plugin to get channel for android and ios.

## How to use

###1、add plugin in pubspec.yaml

```
   channel_plugin:
    git:
      url: https://github.com/June93/channel_plugin.git
```

###2、On ios, it always returns "apple"

###3、On android, you need to do this

```
//to config in AndroidManifest.xml
<!--渠道标识-->
<meta-data
android:name="channel"
android:value="${CHANNEL}" />

//in gradle
flavorDimensions "default"
productFlavors {
        qihoo {
            manifestPlaceholders = [
                    CHANNEL: "qihoo"
            ]
            dimension "default"
        }
}
```

###3、get result

```
String _channel = await ChannelPlugin.getChannel();
```

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.
