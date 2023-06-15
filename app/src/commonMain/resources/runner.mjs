import { instantiate } from './hello-kotlin-wasm-app-wasm.uninstantiated.mjs';
import { WASI } from 'wasi';
import { argv, env } from 'node:process';

export const wasi = new WASI({
    version: 'preview1',
    args: argv,
    env,
    preopens: {
        '/sandbox': process.cwd()
    }
});

const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport }, false);
wasi.initialize(instance);

exports.__init()
