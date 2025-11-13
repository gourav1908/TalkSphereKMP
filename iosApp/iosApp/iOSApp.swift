import SwiftUI
import FirebaseCore
import FirebaseFirestore
import FirebaseAuth

@main
struct iOSApp: App {

    init() {
        FirebaseApp.configure()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
