
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/input_host.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface TextSuggestionHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends TextSuggestionHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<TextSuggestionHost, TextSuggestionHost.Proxy> MANAGER = TextSuggestionHost_Internal.MANAGER;


    void startSuggestionMenuTimer(
);



    void showSpellCheckSuggestionMenu(
double caretX, double caretY, String markedText, SpellCheckSuggestion[] suggestions);



    void showTextSuggestionMenu(
double caretX, double caretY, String markedText, TextSuggestion[] suggestions);


}
