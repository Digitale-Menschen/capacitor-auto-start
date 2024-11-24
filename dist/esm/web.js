import { WebPlugin } from '@capacitor/core';
export class CapacitorAutoStartWeb extends WebPlugin {
    isEnabled() {
        return new Promise(resolve => {
            resolve({
                bootReceiver: false,
                packageReplacer: false,
                userPresent: false,
            });
        });
    }
    // eslint-disable-next-line no-empty-pattern
    enable({}) {
        return new Promise(resolve => {
            console.log('AutoStart not avaiable on web  platform');
            resolve();
        });
    }
}
//# sourceMappingURL=web.js.map