class ServiceApp(App):
    def build(self):
        from jnius import autoclass

        Intent = autoclass('android.content.Intent')
        LbrynetService = autoclass('io.lbry.lbrynet.LbrynetService')
        
if __name__ == '__main__':
    ServiceApp().run()

