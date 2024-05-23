#import "CheckDeviceAutoTime.h"
#import <React/RCTBridgeModule.h>
#import <CoreLocation/CoreLocation.h>

@implementation CheckDeviceAutoTime

RCT_EXPORT_MODULE()



RCT_REMAP_METHOD(isAutomaticTimeEnabled,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject) {
    @try {
        NSTimeZone *localTimeZone = [NSTimeZone localTimeZone];
        NSTimeZone *systemTimeZone = [NSTimeZone systemTimeZone];
        BOOL isAutoTimeEnabled = [localTimeZone isEqualToTimeZone:systemTimeZone];
        resolve(@(isAutoTimeEnabled));
    }
    @catch (NSException *exception) {
        reject(@"SettingsError", @"Could not retrieve automatic time setting.", nil);
    }
}

@end
