// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorAutoStart",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorAutoStart",
            targets: ["CapacitorAutoStartPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CapacitorAutoStartPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CapacitorAutoStartPlugin"),
        .testTarget(
            name: "CapacitorAutoStartPluginTests",
            dependencies: ["CapacitorAutoStartPlugin"],
            path: "ios/Tests/CapacitorAutoStartPluginTests")
    ]
)