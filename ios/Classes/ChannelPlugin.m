#import "ChannelPlugin.h"

@implementation ChannelPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"channel_plugin"
            binaryMessenger:[registrar messenger]];
  ChannelPlugin* instance = [[ChannelPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getPlatformVersion" isEqualToString:call.method]) {
    result([@"iOS " stringByAppendingString:[[UIDevice currentDevice] systemVersion]]);
  } else if ([@"getChannel" isEqualToString:call.method]) {
    result([@"apple"]);
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
