# capacitor-auto-start

This is capacitor plugin for app autostart after boot up, package update inspired from originally cordova plugin https://github.com/ToniKorin/cordova-plugin-autostart
It initializes the app after boot up, package update and user present.

ONLY ANDROID SUPPORT FOR NOW

## Install

```bash
npm install capacitor-auto-start
npx cap sync
```

## API

<docgen-index>

* [`enable(...)`](#enable)
* [`isEnabled()`](#isenabled)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### enable(...)

```typescript
enable({ enable, enableService, }: { enable: boolean; enableService: boolean; }) => Promise<void>
```

| Param     | Type                                                      |
| --------- | --------------------------------------------------------- |
| **`__0`** | <code>{ enable: boolean; enableService: boolean; }</code> |

--------------------


### isEnabled()

```typescript
isEnabled() => Promise<{ bootReceiver: boolean; packageReplacer: boolean; userPresent: boolean; }>
```

**Returns:** <code>Promise&lt;{ bootReceiver: boolean; packageReplacer: boolean; userPresent: boolean; }&gt;</code>

--------------------

</docgen-api>
