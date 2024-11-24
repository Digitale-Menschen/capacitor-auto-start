import { registerPlugin } from '@capacitor/core';

import type { CapacitorAutoStartPlugin } from './definitions';

const CapacitorAutoStart = registerPlugin<CapacitorAutoStartPlugin>('CapacitorAutoStart', {
  web: () => import('./web').then((m) => new m.CapacitorAutoStartWeb()),
});

export * from './definitions';
export { CapacitorAutoStart };
