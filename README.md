# react-native-check-device-auto-time

A React Native library to check if the device's automatic time setting is enabled on both Android and iOS platforms using native code.

## Installation

1. **Install the library:**
   ```sh
   npm install react-native-check-device-auto-time
   ```
   or
   ```sh
   yarn add react-native-check-device-auto-time
   ```

2. **Link the native modules:**

   For React Native 0.60 and above, the linking is done automatically. For older versions, you might need to link the library manually:

   ```sh
   react-native link react-native-check-device-auto-time
   ```

## Usage

1. **Import the library:**

   ```javascript
   import CheckDeviceAutoTime from 'react-native-check-device-auto-time';
   ```

2. **Use the `isAutomaticTimeEnabled` function in your React Native component:**

   ```javascript
   import React, { useEffect, useState } from 'react';
   import { View, Text } from 'react-native';
   import CheckDeviceAutoTime from 'react-native-check-device-auto-time';

   const App = () => {
       const [isAutoTimeEnabled, setIsAutoTimeEnabled] = useState(false);

       useEffect(() => {
           const checkAutoTime = async () => {
               const isEnabled = await CheckDeviceAutoTime.isAutomaticTimeEnabled();
               setIsAutoTimeEnabled(isEnabled);
           };

           checkAutoTime();
       }, []);

       return (
           <View>
               <Text>Automatic Time Enabled: {isAutoTimeEnabled ? 'Yes' : 'No'}</Text>
           </View>
       );
   };

   export default App;
   ```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
