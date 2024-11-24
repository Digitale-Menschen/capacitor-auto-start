export interface CapacitorAutoStartPlugin {
  enable({
    enable,
    enableService,
  }: {
    enable: boolean;
    enableService: boolean;
  }): Promise<void>;

  isEnabled(): Promise<{
    bootReceiver: boolean;
    packageReplacer: boolean;
    userPresent: boolean;
  }>;
}
