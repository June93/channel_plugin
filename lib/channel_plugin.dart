import 'dart:async';

import 'package:flutter/services.dart';

class ChannelPlugin {
  static const MethodChannel _channel = const MethodChannel('channel_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> getChannel() async {
    return await _channel.invokeMethod("getChannel", null);
  }
}
