var capacitorCapacitorAutoStart = (function (exports, core) {
    'use strict';

    const CapacitorAutoStart = core.registerPlugin('CapacitorAutoStart', {
        web: () => Promise.resolve().then(function () { return web; }).then((m) => new m.CapacitorAutoStartWeb()),
    });

    class CapacitorAutoStartWeb extends core.WebPlugin {
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

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        CapacitorAutoStartWeb: CapacitorAutoStartWeb
    });

    exports.CapacitorAutoStart = CapacitorAutoStart;

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
