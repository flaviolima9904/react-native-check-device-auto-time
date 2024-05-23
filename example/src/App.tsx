import * as React from 'react';

import { StyleSheet, View, Text, AppState } from 'react-native';
import CheckDeviceAutoTime from 'react-native-check-device-auto-time';

export default function App() {
  const [result, setResult] = React.useState<boolean | undefined>();
  const appState = React.useRef(AppState.currentState);

  React.useEffect(() => {
    const subscription = AppState.addEventListener('change', (nextAppState) => {
      if (
        appState.current.match(/inactive|background/) &&
        nextAppState === 'active'
      ) {
        CheckDeviceAutoTime.isAutomaticTimeEnabled().then(setResult);
      }
      appState.current = nextAppState;
    });

    return () => {
      subscription.remove();
    };
  }, []);

  return (
    <View style={styles.container}>
      <Text>Automatic time is: {result ? 'Enable' : 'Disabled'}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
