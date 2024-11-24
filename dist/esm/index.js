import { registerPlugin } from '@capacitor/core';
const CapacitorAutoStart = registerPlugin('CapacitorAutoStart', {
    web: () => import('./web').then((m) => new m.CapacitorAutoStartWeb()),
});
export * from './definitions';
export { CapacitorAutoStart };
//# sourceMappingURL=index.js.map