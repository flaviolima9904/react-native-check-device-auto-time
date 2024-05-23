
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNCheckDeviceAutoTimeSpec.h"

@interface CheckDeviceAutoTime : NSObject <NativeCheckDeviceAutoTimeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface CheckDeviceAutoTime : NSObject <RCTBridgeModule>
#endif

@end
