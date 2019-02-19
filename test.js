!(function () {
    function simulate(target, o) {
        var event = target.ownerDocument.createEvent('MouseEvents'),
            options = o || {},
            opts = { // These are the default values, set up for un-modified left clicks
                type: 'mousedown',
                canBubble: true,
                cancelable: true,
                view: target.ownerDocument.defaultView,
                detail: 1,
                screenX: 0, // The coordinates within the entire page
                screenY: 0,
                clientX: 0, // The coordinates within the viewport
                clientY: 0,
                ctrlKey: false,
                altKey: false,
                shiftKey: false,
                metaKey: false, // I *think* 'meta' is 'Cmd/Apple' on Mac, and 'Windows key' on Win. Not sure, though!
                button: 0, // 0 = left, 1 = middle, 2 = right
                relatedTarget: null
            };

        // Merge the options with the defaults
        for (let key in options) {
            if (options.hasOwnProperty(key)) {
                opts[key] = options[key];
            }
        }

        // Pass in the options
        event.initMouseEvent(
            opts.type,
            opts.canBubble,
            opts.cancelable,
            opts.view,
            opts.detail,
            opts.screenX,
            opts.screenY,
            opts.clientX,
            opts.clientY,
            opts.ctrlKey,
            opts.altKey,
            opts.shiftKey,
            opts.metaKey,
            opts.button,
            opts.relatedTarget
        );

        // Fire the event
        target.dispatchEvent(event);
    }

    try {
        // 获取“显示余额”节点偏移量
        let screenX = 55;
        let screenY = 291;
        let clientX = 120;
        let clientY = 294;
        try {
            const saa = document.getElementById('showAccountAmount');

            let randomX = Math.random() * 30;
            let randomY = Math.random() * 12;
            screenX += randomX;
            screenY += randomY;
            clientX = saa.getBoundingClientRect().left + randomX;
            clientY = saa.getBoundingClientRect().top + randomY;
        } catch (e) {
        }

        // 点击花呗额度按钮
        simulate(document.getElementById('showAccountAmount'), {
            screenX,
            screenY,
            clientX,
            clientY
        });
    } catch (e) {
    }
})();
