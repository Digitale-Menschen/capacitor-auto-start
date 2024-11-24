import { WebPlugin } from '@capacitor/core';
import type { CapacitorAutoStartPlugin } from './definitions';
export declare class CapacitorAutoStartWeb extends WebPlugin implements CapacitorAutoStartPlugin {
    isEnabled(): Promise<{
        bootReceiver: boolean;
        packageReplacer: boolean;
        userPresent: boolean;
    }>;
    enable({}: {
        enable: boolean;
        enableService: boolean;
    }): Promise<void>;
}
