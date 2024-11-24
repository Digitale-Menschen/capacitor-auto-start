import { WebPlugin } from '@capacitor/core';

import type { CapacitorAutoStartPlugin } from './definitions';

export class CapacitorAutoStartWeb
  extends WebPlugin
  implements CapacitorAutoStartPlugin
{
  isEnabled(): Promise<{
    bootReceiver: boolean;
    packageReplacer: boolean;
    userPresent: boolean;
  }> {
    return new Promise(resolve => {
      resolve({
        bootReceiver: false,
        packageReplacer: false,
        userPresent: false,
      });
    });
  }

  // eslint-disable-next-line no-empty-pattern
  enable({}: { enable: boolean; enableService: boolean }): Promise<void> {
    return new Promise(resolve => {
      console.log('AutoStart not avaiable on web  platform');
      resolve();
    });
  }
}
