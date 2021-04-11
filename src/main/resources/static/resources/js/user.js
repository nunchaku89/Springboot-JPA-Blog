let index = {
    init: function () {
        $("button[data-role=btnRegister]").on("click", () => {
            this.register();
        });
    },

    register: function () {
        alert('a');
    }
}

index.init();