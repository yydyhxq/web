﻿/*
Copyright 2014 Igor Vaynberg

Version: 3.5.0 Timestamp: Mon Jun 16 19:29:44 EDT 2014

This software is licensed under the Apache License, Version 2.0 (the "Apache License") or the GNU
General Public License version 2 (the "GPL License"). You may choose either license to govern your
use of this software only upon the condition that you accept all of the terms of either the Apache
License or the GPL License.

You may obtain a copy of the Apache License and the GPL License at:

http://www.apache.org/licenses/LICENSE-2.0
http://www.gnu.org/licenses/gpl-2.0.html

Unless required by applicable law or agreed to in writing, software distributed under the Apache License
or the GPL Licesnse is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the Apache License and the GPL License for the specific language governing
permissions and limitations under the Apache License and the GPL License.
*/
!
function(a) {
	"undefined" == typeof a.fn.each2 && a.extend(a.fn, {
		each2: function(b) {
			for (var c = a([0]), d = -1, e = this.length; ++d < e && (c.context = c[0] = this[d]) && b.call(c[0], d, c) !== !1;);
			return this
		}
	})
}(jQuery), function(a, b) {
	"use strict";

	function n(b) {
		var c = a(document.createTextNode(""));
		b.before(c), c.before(b), c.remove()
	}
	function o(a) {
		function b(a) {
			return m[a] || a
		}
		return a.replace(/[^-~]/g, b)
	}
	function p(a, b) {
		for (var c = 0, d = b.length; d > c; c += 1) if (r(a, b[c])) return c;
		return -1
	}
	function q() {
		var b = a(l);
		b.appendTo("body");
		var c = {
			width: b.width() - b[0].clientWidth,
			height: b.height() - b[0].clientHeight
		};
		return b.remove(), c
	}
	function r(a, c) {
		return a === c ? !0 : a === b || c === b ? !1 : null === a || null === c ? !1 : a.constructor === String ? a + "" == c + "" : c.constructor === String ? c + "" == a + "" : !1
	}
	function s(b, c) {
		var d, e, f;
		if (null === b || b.length < 1) return [];
		for (d = b.split(c), e = 0, f = d.length; f > e; e += 1) d[e] = a.trim(d[e]);
		return d
	}
	function t(a) {
		return a.outerWidth(!1) - a.width()
	}
	function u(c) {
		var d = "keyup-change-value";
		c.on("keydown", function() {
			a.data(c, d) === b && a.data(c, d, c.val())
		}), c.on("keyup", function() {
			var e = a.data(c, d);
			e !== b && c.val() !== e && (a.removeData(c, d), c.trigger("keyup-change"))
		})
	}
	function v(c) {
		c.on("mousemove", function(c) {
			var d = i;
			(d === b || d.x !== c.pageX || d.y !== c.pageY) && a(c.target).trigger("mousemove-filtered", c)
		})
	}
	function w(a, c, d) {
		d = d || b;
		var e;
		return function() {
			var b = arguments;
			window.clearTimeout(e), e = window.setTimeout(function() {
				c.apply(d, b)
			}, a)
		}
	}
	function x(a, b) {
		var c = w(a, function(a) {
			b.trigger("scroll-debounced", a)
		});
		b.on("scroll", function(a) {
			p(a.target, b.get()) >= 0 && c(a)
		})
	}
	function y(a) {
		a[0] !== document.activeElement && window.setTimeout(function() {
			var d, b = a[0],
				c = a.val().length;
			a.focus();
			var e = b.offsetWidth > 0 || b.offsetHeight > 0;
			e && b === document.activeElement && (b.setSelectionRange ? b.setSelectionRange(c, c) : b.createTextRange && (d = b.createTextRange(), d.collapse(!1), d.select()))
		}, 0)
	}
	function z(b) {
		b = a(b)[0];
		var c = 0,
			d = 0;
		if ("selectionStart" in b) c = b.selectionStart, d = b.selectionEnd - c;
		else if ("selection" in document) {
			b.focus();
			var e = document.selection.createRange();
			d = document.selection.createRange().text.length, e.moveStart("character", -b.value.length), c = e.text.length - d
		}
		return {
			offset: c,
			length: d
		}
	}
	function A(a) {
		a.preventDefault(), a.stopPropagation()
	}
	function B(a) {
		a.preventDefault(), a.stopImmediatePropagation()
	}
	function C(b) {
		if (!h) {
			var c = b[0].currentStyle || window.getComputedStyle(b[0], null);
			h = a(document.createElement("div")).css({
				position: "absolute",
				left: "-10000px",
				top: "-10000px",
				display: "none",
				fontSize: c.fontSize,
				fontFamily: c.fontFamily,
				fontStyle: c.fontStyle,
				fontWeight: c.fontWeight,
				letterSpacing: c.letterSpacing,
				textTransform: c.textTransform,
				whiteSpace: "nowrap"
			}), h.attr("class", "select2-sizer"), a("body").append(h)
		}
		return h.text(b.val()), h.width()
	}
	function D(b, c, d) {
		var e, g, f = [];
		e = a.trim(b.attr("class")), e && (e = "" + e, a(e.split(/\s+/)).each2(function() {
			0 === this.indexOf("select2-") && f.push(this)
		})), e = a.trim(c.attr("class")), e && (e = "" + e, a(e.split(/\s+/)).each2(function() {
			0 !== this.indexOf("select2-") && (g = d(this), g && f.push(g))
		})), b.attr("class", f.join(" "))
	}
	function E(a, b, c, d) {
		var e = o(a.toUpperCase()).indexOf(o(b.toUpperCase())),
			f = b.length;
		return 0 > e ? (c.push(d(a)), void 0) : (c.push(d(a.substring(0, e))), c.push("<span class='select2-match'>"), c.push(d(a.substring(e, e + f))), c.push("</span>"), c.push(d(a.substring(e + f, a.length))), void 0);
	}
	function F(a) {
		var b = {
			"\\": "&#92;",
			"&": "&amp;",
			"<": "&lt;",
			">": "&gt;",
			'"': "&quot;",
			"'": "&#39;",
			"/": "&#47;"
		};
		return String(a).replace(/[&<>"'\/\\]/g, function(a) {
			return b[a]
		})
	}
	function G(c) {
		var d, e = null,
			f = c.quietMillis || 100,
			g = c.url,
			h = this;
		return function(i) {
			window.clearTimeout(d), d = window.setTimeout(function() {
				var d = c.data,
					f = g,
					j = c.transport || a.fn.select2.ajaxDefaults.transport,
					k = {
						type: c.type || "GET",
						cache: c.cache || !1,
						jsonpCallback: c.jsonpCallback || b,
						dataType: c.dataType || "json"
					},
					l = a.extend({}, a.fn.select2.ajaxDefaults.params, k);
				d = d ? d.call(h, i.term, i.page, i.context) : null, f = "function" == typeof f ? f.call(h, i.term, i.page, i.context) : f, e && "function" == typeof e.abort && e.abort(), c.params && (a.isFunction(c.params) ? a.extend(l, c.params.call(h)) : a.extend(l, c.params)), a.extend(l, {
					url: f,
					dataType: c.dataType,
					data: d,
					success: function(a) {
						var b = c.results(a, i.page, i);
						i.callback(b)
					}
				}), e = j.call(h, l)
			}, f)
		}
	}
	function H(b) {
		var d, e, c = b,
			f = function(a) {
				return "" + a.text
			};
		a.isArray(c) && (e = c, c = {
			results: e
		}), a.isFunction(c) === !1 && (e = c, c = function() {
			return e
		});
		var g = c();
		return g.text && (f = g.text, a.isFunction(f) || (d = g.text, f = function(a) {
			return a[d]
		})), function(b) {
			var g, d = b.term,
				e = {
					results: []
				};
			return "" === d ? (b.callback(c()), void 0) : (g = function(c, e) {
				var h, i;
				if (c = c[0], c.children) {
					h = {};
					for (i in c) c.hasOwnProperty(i) && (h[i] = c[i]);
					h.children = [], a(c.children).each2(function(a, b) {
						g(b, h.children)
					}), (h.children.length || b.matcher(d, f(h), c)) && e.push(h)
				} else b.matcher(d, f(c), c) && e.push(c)
			}, a(c().results).each2(function(a, b) {
				g(b, e.results)
			}), b.callback(e), void 0)
		}
	}
	function I(c) {
		var d = a.isFunction(c);
		return function(e) {
			var f = e.term,
				g = {
					results: []
				},
				h = d ? c(e) : c;
			a.isArray(h) && (a(h).each(function() {
				var a = this.text !== b,
					c = a ? this.text : this;
				("" === f || e.matcher(f, c)) && g.results.push(a ? this : {
					id: this,
					text: this
				})
			}), e.callback(g))
		}
	}
	function J(b, c) {
		if (a.isFunction(b)) return !0;
		if (!b) return !1;
		if ("string" == typeof b) return !0;
		throw new Error(c + " must be a string, function, or falsy value")
	}
	function K(b, c) {
		if (a.isFunction(b)) {
			var d = Array.prototype.slice.call(arguments, 2);
			return b.apply(c, d)
		}
		return b
	}
	function L(b) {
		var c = 0;
		return a.each(b, function(a, b) {
			b.children ? c += L(b.children) : c++
		}), c
	}
	function M(a, c, d, e) {
		var h, i, j, k, l, f = a,
			g = !1;
		if (!e.createSearchChoice || !e.tokenSeparators || e.tokenSeparators.length < 1) return b;
		for (;;) {
			for (i = -1, j = 0, k = e.tokenSeparators.length; k > j && (l = e.tokenSeparators[j], i = a.indexOf(l), !(i >= 0)); j++);
			if (0 > i) break;
			if (h = a.substring(0, i), a = a.substring(i + l.length), h.length > 0 && (h = e.createSearchChoice.call(this, h, c), h !== b && null !== h && e.id(h) !== b && null !== e.id(h))) {
				for (g = !1, j = 0, k = c.length; k > j; j++) if (r(e.id(h), e.id(c[j]))) {
					g = !0;
					break
				}
				g || d(h)
			}
		}
		return f !== a ? a : void 0
	}
	function N() {
		var b = this;
		a.each(arguments, function(a, c) {
			b[c].remove(), b[c] = null
		})
	}
	function O(b, c) {
		var d = function() {};
		return d.prototype = new b, d.prototype.constructor = d, d.prototype.parent = b.prototype, d.prototype = a.extend(d.prototype, c), d
	}
	if (window.Select2 === b) {
		var c, d, e, f, g, h, j, k, i = {
			x: 0,
			y: 0
		},
			c = {
				TAB: 9,
				ENTER: 13,
				ESC: 27,
				SPACE: 32,
				LEFT: 37,
				UP: 38,
				RIGHT: 39,
				DOWN: 40,
				SHIFT: 16,
				CTRL: 17,
				ALT: 18,
				PAGE_UP: 33,
				PAGE_DOWN: 34,
				HOME: 36,
				END: 35,
				BACKSPACE: 8,
				DELETE: 46,
				isArrow: function(a) {
					switch (a = a.which ? a.which : a) {
					case c.LEFT:
					case c.RIGHT:
					case c.UP:
					case c.DOWN:
						return !0
					}
					return !1
				},
				isControl: function(a) {
					var b = a.which;
					switch (b) {
					case c.SHIFT:
					case c.CTRL:
					case c.ALT:
						return !0
					}
					return a.metaKey ? !0 : !1
				},
				isFunctionKey: function(a) {
					return a = a.which ? a.which : a, a >= 112 && 123 >= a
				}
			},
			l = "<div class='select2-measure-scrollbar'></div>",
			m = {
				"Ⓐ": "A",
				"Ａ": "A",
				"À": "A",
				"Á": "A",
				"Â": "A",
				"Ầ": "A",
				"Ấ": "A",
				"Ẫ": "A",
				"Ẩ": "A",
				"Ã": "A",
				"Ā": "A",
				"Ă": "A",
				"Ằ": "A",
				"Ắ": "A",
				"Ẵ": "A",
				"Ẳ": "A",
				"Ȧ": "A",
				"Ǡ": "A",
				"Ä": "A",
				"Ǟ": "A",
				"Ả": "A",
				"Å": "A",
				"Ǻ": "A",
				"Ǎ": "A",
				"Ȁ": "A",
				"Ȃ": "A",
				"Ạ": "A",
				"Ậ": "A",
				"Ặ": "A",
				"Ḁ": "A",
				"Ą": "A",
				"Ⱥ": "A",
				"Ɐ": "A",
				"Ꜳ": "AA",
				"Æ": "AE",
				"Ǽ": "AE",
				"Ǣ": "AE",
				"Ꜵ": "AO",
				"Ꜷ": "AU",
				"Ꜹ": "AV",
				"Ꜻ": "AV",
				"Ꜽ": "AY",
				"Ⓑ": "B",
				"Ｂ": "B",
				"Ḃ": "B",
				"Ḅ": "B",
				"Ḇ": "B",
				"Ƀ": "B",
				"Ƃ": "B",
				"Ɓ": "B",
				"Ⓒ": "C",
				"Ｃ": "C",
				"Ć": "C",
				"Ĉ": "C",
				"Ċ": "C",
				"Č": "C",
				"Ç": "C",
				"Ḉ": "C",
				"Ƈ": "C",
				"Ȼ": "C",
				"Ꜿ": "C",
				"Ⓓ": "D",
				"Ｄ": "D",
				"Ḋ": "D",
				"Ď": "D",
				"Ḍ": "D",
				"Ḑ": "D",
				"Ḓ": "D",
				"Ḏ": "D",
				"Đ": "D",
				"Ƌ": "D",
				"Ɗ": "D",
				"Ɖ": "D",
				"Ꝺ": "D",
				"Ǳ": "DZ",
				"Ǆ": "DZ",
				"ǲ": "Dz",
				"ǅ": "Dz",
				"Ⓔ": "E",
				"Ｅ": "E",
				"È": "E",
				"É": "E",
				"Ê": "E",
				"Ề": "E",
				"Ế": "E",
				"Ễ": "E",
				"Ể": "E",
				"Ẽ": "E",
				"Ē": "E",
				"Ḕ": "E",
				"Ḗ": "E",
				"Ĕ": "E",
				"Ė": "E",
				"Ë": "E",
				"Ẻ": "E",
				"Ě": "E",
				"Ȅ": "E",
				"Ȇ": "E",
				"Ẹ": "E",
				"Ệ": "E",
				"Ȩ": "E",
				"Ḝ": "E",
				"Ę": "E",
				"Ḙ": "E",
				"Ḛ": "E",
				"Ɛ": "E",
				"Ǝ": "E",
				"Ⓕ": "F",
				"Ｆ": "F",
				"Ḟ": "F",
				"Ƒ": "F",
				"Ꝼ": "F",
				"Ⓖ": "G",
				"Ｇ": "G",
				"Ǵ": "G",
				"Ĝ": "G",
				"Ḡ": "G",
				"Ğ": "G",
				"Ġ": "G",
				"Ǧ": "G",
				"Ģ": "G",
				"Ǥ": "G",
				"Ɠ": "G",
				"Ꞡ": "G",
				"Ᵹ": "G",
				"Ꝿ": "G",
				"Ⓗ": "H",
				"Ｈ": "H",
				"Ĥ": "H",
				"Ḣ": "H",
				"Ḧ": "H",
				"Ȟ": "H",
				"Ḥ": "H",
				"Ḩ": "H",
				"Ḫ": "H",
				"Ħ": "H",
				"Ⱨ": "H",
				"Ⱶ": "H",
				"Ɥ": "H",
				"Ⓘ": "I",
				"Ｉ": "I",
				"Ì": "I",
				"Í": "I",
				"Î": "I",
				"Ĩ": "I",
				"Ī": "I",
				"Ĭ": "I",
				"İ": "I",
				"Ï": "I",
				"Ḯ": "I",
				"Ỉ": "I",
				"Ǐ": "I",
				"Ȉ": "I",
				"Ȋ": "I",
				"Ị": "I",
				"Į": "I",
				"Ḭ": "I",
				"Ɨ": "I",
				"Ⓙ": "J",
				"Ｊ": "J",
				"Ĵ": "J",
				"Ɉ": "J",
				"Ⓚ": "K",
				"Ｋ": "K",
				"Ḱ": "K",
				"Ǩ": "K",
				"Ḳ": "K",
				"Ķ": "K",
				"Ḵ": "K",
				"Ƙ": "K",
				"Ⱪ": "K",
				"Ꝁ": "K",
				"Ꝃ": "K",
				"Ꝅ": "K",
				"Ꞣ": "K",
				"Ⓛ": "L",
				"Ｌ": "L",
				"Ŀ": "L",
				"Ĺ": "L",
				"Ľ": "L",
				"Ḷ": "L",
				"Ḹ": "L",
				"Ļ": "L",
				"Ḽ": "L",
				"Ḻ": "L",
				"Ł": "L",
				"Ƚ": "L",
				"Ɫ": "L",
				"Ⱡ": "L",
				"Ꝉ": "L",
				"Ꝇ": "L",
				"Ꞁ": "L",
				"Ǉ": "LJ",
				"ǈ": "Lj",
				"Ⓜ": "M",
				"Ｍ": "M",
				"Ḿ": "M",
				"Ṁ": "M",
				"Ṃ": "M",
				"Ɱ": "M",
				"Ɯ": "M",
				"Ⓝ": "N",
				"Ｎ": "N",
				"Ǹ": "N",
				"Ń": "N",
				"Ñ": "N",
				"Ṅ": "N",
				"Ň": "N",
				"Ṇ": "N",
				"Ņ": "N",
				"Ṋ": "N",
				"Ṉ": "N",
				"Ƞ": "N",
				"Ɲ": "N",
				"Ꞑ": "N",
				"Ꞥ": "N",
				"Ǌ": "NJ",
				"ǋ": "Nj",
				"Ⓞ": "O",
				"Ｏ": "O",
				"Ò": "O",
				"Ó": "O",
				"Ô": "O",
				"Ồ": "O",
				"Ố": "O",
				"Ỗ": "O",
				"Ổ": "O",
				"Õ": "O",
				"Ṍ": "O",
				"Ȭ": "O",
				"Ṏ": "O",
				"Ō": "O",
				"Ṑ": "O",
				"Ṓ": "O",
				"Ŏ": "O",
				"Ȯ": "O",
				"Ȱ": "O",
				"Ö": "O",
				"Ȫ": "O",
				"Ỏ": "O",
				"Ő": "O",
				"Ǒ": "O",
				"Ȍ": "O",
				"Ȏ": "O",
				"Ơ": "O",
				"Ờ": "O",
				"Ớ": "O",
				"Ỡ": "O",
				"Ở": "O",
				"Ợ": "O",
				"Ọ": "O",
				"Ộ": "O",
				"Ǫ": "O",
				"Ǭ": "O",
				"Ø": "O",
				"Ǿ": "O",
				"Ɔ": "O",
				"Ɵ": "O",
				"Ꝋ": "O",
				"Ꝍ": "O",
				"Ƣ": "OI",
				"Ꝏ": "OO",
				"Ȣ": "OU",
				"Ⓟ": "P",
				"Ｐ": "P",
				"Ṕ": "P",
				"Ṗ": "P",
				"Ƥ": "P",
				"Ᵽ": "P",
				"Ꝑ": "P",
				"Ꝓ": "P",
				"Ꝕ": "P",
				"Ⓠ": "Q",
				"Ｑ": "Q",
				"Ꝗ": "Q",
				"Ꝙ": "Q",
				"Ɋ": "Q",
				"Ⓡ": "R",
				"Ｒ": "R",
				"Ŕ": "R",
				"Ṙ": "R",
				"Ř": "R",
				"Ȑ": "R",
				"Ȓ": "R",
				"Ṛ": "R",
				"Ṝ": "R",
				"Ŗ": "R",
				"Ṟ": "R",
				"Ɍ": "R",
				"Ɽ": "R",
				"Ꝛ": "R",
				"Ꞧ": "R",
				"Ꞃ": "R",
				"Ⓢ": "S",
				"Ｓ": "S",
				"ẞ": "S",
				"Ś": "S",
				"Ṥ": "S",
				"Ŝ": "S",
				"Ṡ": "S",
				"Š": "S",
				"Ṧ": "S",
				"Ṣ": "S",
				"Ṩ": "S",
				"Ș": "S",
				"Ş": "S",
				"Ȿ": "S",
				"Ꞩ": "S",
				"Ꞅ": "S",
				"Ⓣ": "T",
				"Ｔ": "T",
				"Ṫ": "T",
				"Ť": "T",
				"Ṭ": "T",
				"Ț": "T",
				"Ţ": "T",
				"Ṱ": "T",
				"Ṯ": "T",
				"Ŧ": "T",
				"Ƭ": "T",
				"Ʈ": "T",
				"Ⱦ": "T",
				"Ꞇ": "T",
				"Ꜩ": "TZ",
				"Ⓤ": "U",
				"Ｕ": "U",
				"Ù": "U",
				"Ú": "U",
				"Û": "U",
				"Ũ": "U",
				"Ṹ": "U",
				"Ū": "U",
				"Ṻ": "U",
				"Ŭ": "U",
				"Ü": "U",
				"Ǜ": "U",
				"Ǘ": "U",
				"Ǖ": "U",
				"Ǚ": "U",
				"Ủ": "U",
				"Ů": "U",
				"Ű": "U",
				"Ǔ": "U",
				"Ȕ": "U",
				"Ȗ": "U",
				"Ư": "U",
				"Ừ": "U",
				"Ứ": "U",
				"Ữ": "U",
				"Ử": "U",
				"Ự": "U",
				"Ụ": "U",
				"Ṳ": "U",
				"Ų": "U",
				"Ṷ": "U",
				"Ṵ": "U",
				"Ʉ": "U",
				"Ⓥ": "V",
				"Ｖ": "V",
				"Ṽ": "V",
				"Ṿ": "V",
				"Ʋ": "V",
				"Ꝟ": "V",
				"Ʌ": "V",
				"Ꝡ": "VY",
				"Ⓦ": "W",
				"Ｗ": "W",
				"Ẁ": "W",
				"Ẃ": "W",
				"Ŵ": "W",
				"Ẇ": "W",
				"Ẅ": "W",
				"Ẉ": "W",
				"Ⱳ": "W",
				"Ⓧ": "X",
				"Ｘ": "X",
				"Ẋ": "X",
				"Ẍ": "X",
				"Ⓨ": "Y",
				"Ｙ": "Y",
				"Ỳ": "Y",
				"Ý": "Y",
				"Ŷ": "Y",
				"Ỹ": "Y",
				"Ȳ": "Y",
				"Ẏ": "Y",
				"Ÿ": "Y",
				"Ỷ": "Y",
				"Ỵ": "Y",
				"Ƴ": "Y",
				"Ɏ": "Y",
				"Ỿ": "Y",
				"Ⓩ": "Z",
				"Ｚ": "Z",
				"Ź": "Z",
				"Ẑ": "Z",
				"Ż": "Z",
				"Ž": "Z",
				"Ẓ": "Z",
				"Ẕ": "Z",
				"Ƶ": "Z",
				"Ȥ": "Z",
				"Ɀ": "Z",
				"Ⱬ": "Z",
				"Ꝣ": "Z",
				"ⓐ": "a",
				"ａ": "a",
				"ẚ": "a",
				"à": "a",
				"á": "a",
				"â": "a",
				"ầ": "a",
				"ấ": "a",
				"ẫ": "a",
				"ẩ": "a",
				"ã": "a",
				"ā": "a",
				"ă": "a",
				"ằ": "a",
				"ắ": "a",
				"ẵ": "a",
				"ẳ": "a",
				"ȧ": "a",
				"ǡ": "a",
				"ä": "a",
				"ǟ": "a",
				"ả": "a",
				"å": "a",
				"ǻ": "a",
				"ǎ": "a",
				"ȁ": "a",
				"ȃ": "a",
				"ạ": "a",
				"ậ": "a",
				"ặ": "a",
				"ḁ": "a",
				"ą": "a",
				"ⱥ": "a",
				"ɐ": "a",
				"ꜳ": "aa",
				"æ": "ae",
				"ǽ": "ae",
				"ǣ": "ae",
				"ꜵ": "ao",
				"ꜷ": "au",
				"ꜹ": "av",
				"ꜻ": "av",
				"ꜽ": "ay",
				"ⓑ": "b",
				"ｂ": "b",
				"ḃ": "b",
				"ḅ": "b",
				"ḇ": "b",
				"ƀ": "b",
				"ƃ": "b",
				"ɓ": "b",
				"ⓒ": "c",
				"ｃ": "c",
				"ć": "c",
				"ĉ": "c",
				"ċ": "c",
				"č": "c",
				"ç": "c",
				"ḉ": "c",
				"ƈ": "c",
				"ȼ": "c",
				"ꜿ": "c",
				"ↄ": "c",
				"ⓓ": "d",
				"ｄ": "d",
				"ḋ": "d",
				"ď": "d",
				"ḍ": "d",
				"ḑ": "d",
				"ḓ": "d",
				"ḏ": "d",
				"đ": "d",
				"ƌ": "d",
				"ɖ": "d",
				"ɗ": "d",
				"ꝺ": "d",
				"ǳ": "dz",
				"ǆ": "dz",
				"ⓔ": "e",
				"ｅ": "e",
				"è": "e",
				"é": "e",
				"ê": "e",
				"ề": "e",
				"ế": "e",
				"ễ": "e",
				"ể": "e",
				"ẽ": "e",
				"ē": "e",
				"ḕ": "e",
				"ḗ": "e",
				"ĕ": "e",
				"ė": "e",
				"ë": "e",
				"ẻ": "e",
				"ě": "e",
				"ȅ": "e",
				"ȇ": "e",
				"ẹ": "e",
				"ệ": "e",
				"ȩ": "e",
				"ḝ": "e",
				"ę": "e",
				"ḙ": "e",
				"ḛ": "e",
				"ɇ": "e",
				"ɛ": "e",
				"ǝ": "e",
				"ⓕ": "f",
				"ｆ": "f",
				"ḟ": "f",
				"ƒ": "f",
				"ꝼ": "f",
				"ⓖ": "g",
				"ｇ": "g",
				"ǵ": "g",
				"ĝ": "g",
				"ḡ": "g",
				"ğ": "g",
				"ġ": "g",
				"ǧ": "g",
				"ģ": "g",
				"ǥ": "g",
				"ɠ": "g",
				"ꞡ": "g",
				"ᵹ": "g",
				"ꝿ": "g",
				"ⓗ": "h",
				"ｈ": "h",
				"ĥ": "h",
				"ḣ": "h",
				"ḧ": "h",
				"ȟ": "h",
				"ḥ": "h",
				"ḩ": "h",
				"ḫ": "h",
				"ẖ": "h",
				"ħ": "h",
				"ⱨ": "h",
				"ⱶ": "h",
				"ɥ": "h",
				"ƕ": "hv",
				"ⓘ": "i",
				"ｉ": "i",
				"ì": "i",
				"í": "i",
				"î": "i",
				"ĩ": "i",
				"ī": "i",
				"ĭ": "i",
				"ï": "i",
				"ḯ": "i",
				"ỉ": "i",
				"ǐ": "i",
				"ȉ": "i",
				"ȋ": "i",
				"ị": "i",
				"į": "i",
				"ḭ": "i",
				"ɨ": "i",
				"ı": "i",
				"ⓙ": "j",
				"ｊ": "j",
				"ĵ": "j",
				"ǰ": "j",
				"ɉ": "j",
				"ⓚ": "k",
				"ｋ": "k",
				"ḱ": "k",
				"ǩ": "k",
				"ḳ": "k",
				"ķ": "k",
				"ḵ": "k",
				"ƙ": "k",
				"ⱪ": "k",
				"ꝁ": "k",
				"ꝃ": "k",
				"ꝅ": "k",
				"ꞣ": "k",
				"ⓛ": "l",
				"ｌ": "l",
				"ŀ": "l",
				"ĺ": "l",
				"ľ": "l",
				"ḷ": "l",
				"ḹ": "l",
				"ļ": "l",
				"ḽ": "l",
				"ḻ": "l",
				"ſ": "l",
				"ł": "l",
				"ƚ": "l",
				"ɫ": "l",
				"ⱡ": "l",
				"ꝉ": "l",
				"ꞁ": "l",
				"ꝇ": "l",
				"ǉ": "lj",
				"ⓜ": "m",
				"ｍ": "m",
				"ḿ": "m",
				"ṁ": "m",
				"ṃ": "m",
				"ɱ": "m",
				"ɯ": "m",
				"ⓝ": "n",
				"ｎ": "n",
				"ǹ": "n",
				"ń": "n",
				"ñ": "n",
				"ṅ": "n",
				"ň": "n",
				"ṇ": "n",
				"ņ": "n",
				"ṋ": "n",
				"ṉ": "n",
				"ƞ": "n",
				"ɲ": "n",
				"ŉ": "n",
				"ꞑ": "n",
				"ꞥ": "n",
				"ǌ": "nj",
				"ⓞ": "o",
				"ｏ": "o",
				"ò": "o",
				"ó": "o",
				"ô": "o",
				"ồ": "o",
				"ố": "o",
				"ỗ": "o",
				"ổ": "o",
				"õ": "o",
				"ṍ": "o",
				"ȭ": "o",
				"ṏ": "o",
				"ō": "o",
				"ṑ": "o",
				"ṓ": "o",
				"ŏ": "o",
				"ȯ": "o",
				"ȱ": "o",
				"ö": "o",
				"ȫ": "o",
				"ỏ": "o",
				"ő": "o",
				"ǒ": "o",
				"ȍ": "o",
				"ȏ": "o",
				"ơ": "o",
				"ờ": "o",
				"ớ": "o",
				"ỡ": "o",
				"ở": "o",
				"ợ": "o",
				"ọ": "o",
				"ộ": "o",
				"ǫ": "o",
				"ǭ": "o",
				"ø": "o",
				"ǿ": "o",
				"ɔ": "o",
				"ꝋ": "o",
				"ꝍ": "o",
				"ɵ": "o",
				"ƣ": "oi",
				"ȣ": "ou",
				"ꝏ": "oo",
				"ⓟ": "p",
				"ｐ": "p",
				"ṕ": "p",
				"ṗ": "p",
				"ƥ": "p",
				"ᵽ": "p",
				"ꝑ": "p",
				"ꝓ": "p",
				"ꝕ": "p",
				"ⓠ": "q",
				"ｑ": "q",
				"ɋ": "q",
				"ꝗ": "q",
				"ꝙ": "q",
				"ⓡ": "r",
				"ｒ": "r",
				"ŕ": "r",
				"ṙ": "r",
				"ř": "r",
				"ȑ": "r",
				"ȓ": "r",
				"ṛ": "r",
				"ṝ": "r",
				"ŗ": "r",
				"ṟ": "r",
				"ɍ": "r",
				"ɽ": "r",
				"ꝛ": "r",
				"ꞧ": "r",
				"ꞃ": "r",
				"ⓢ": "s",
				"ｓ": "s",
				"ß": "s",
				"ś": "s",
				"ṥ": "s",
				"ŝ": "s",
				"ṡ": "s",
				"š": "s",
				"ṧ": "s",
				"ṣ": "s",
				"ṩ": "s",
				"ș": "s",
				"ş": "s",
				"ȿ": "s",
				"ꞩ": "s",
				"ꞅ": "s",
				"ẛ": "s",
				"ⓣ": "t",
				"ｔ": "t",
				"ṫ": "t",
				"ẗ": "t",
				"ť": "t",
				"ṭ": "t",
				"ț": "t",
				"ţ": "t",
				"ṱ": "t",
				"ṯ": "t",
				"ŧ": "t",
				"ƭ": "t",
				"ʈ": "t",
				"ⱦ": "t",
				"ꞇ": "t",
				"ꜩ": "tz",
				"ⓤ": "u",
				"ｕ": "u",
				"ù": "u",
				"ú": "u",
				"û": "u",
				"ũ": "u",
				"ṹ": "u",
				"ū": "u",
				"ṻ": "u",
				"ŭ": "u",
				"ü": "u",
				"ǜ": "u",
				"ǘ": "u",
				"ǖ": "u",
				"ǚ": "u",
				"ủ": "u",
				"ů": "u",
				"ű": "u",
				"ǔ": "u",
				"ȕ": "u",
				"ȗ": "u",
				"ư": "u",
				"ừ": "u",
				"ứ": "u",
				"ữ": "u",
				"ử": "u",
				"ự": "u",
				"ụ": "u",
				"ṳ": "u",
				"ų": "u",
				"ṷ": "u",
				"ṵ": "u",
				"ʉ": "u",
				"ⓥ": "v",
				"ｖ": "v",
				"ṽ": "v",
				"ṿ": "v",
				"ʋ": "v",
				"ꝟ": "v",
				"ʌ": "v",
				"ꝡ": "vy",
				"ⓦ": "w",
				"ｗ": "w",
				"ẁ": "w",
				"ẃ": "w",
				"ŵ": "w",
				"ẇ": "w",
				"ẅ": "w",
				"ẘ": "w",
				"ẉ": "w",
				"ⱳ": "w",
				"ⓧ": "x",
				"ｘ": "x",
				"ẋ": "x",
				"ẍ": "x",
				"ⓨ": "y",
				"ｙ": "y",
				"ỳ": "y",
				"ý": "y",
				"ŷ": "y",
				"ỹ": "y",
				"ȳ": "y",
				"ẏ": "y",
				"ÿ": "y",
				"ỷ": "y",
				"ẙ": "y",
				"ỵ": "y",
				"ƴ": "y",
				"ɏ": "y",
				"ỿ": "y",
				"ⓩ": "z",
				"ｚ": "z",
				"ź": "z",
				"ẑ": "z",
				"ż": "z",
				"ž": "z",
				"ẓ": "z",
				"ẕ": "z",
				"ƶ": "z",
				"ȥ": "z",
				"ɀ": "z",
				"ⱬ": "z",
				"ꝣ": "z",
				"Ά": "Α",
				"Έ": "Ε",
				"Ή": "Η",
				"Ί": "Ι",
				"Ϊ": "Ι",
				"Ό": "Ο",
				"Ύ": "Υ",
				"Ϋ": "Υ",
				"Ώ": "Ω",
				"ά": "α",
				"έ": "ε",
				"ή": "η",
				"ί": "ι",
				"ϊ": "ι",
				"ΐ": "ι",
				"ό": "ο",
				"ύ": "υ",
				"ϋ": "υ",
				"ΰ": "υ",
				"ω": "ω",
				"ς": "σ"
			};
		j = a(document), g = function() {
			var a = 1;
			return function() {
				return a++
			}
		}(), d = O(Object, {
			bind: function(a) {
				var b = this;
				return function() {
					a.apply(b, arguments)
				}
			},
			init: function(c) {
				var d, e, f = ".select2-results";
				this.opts = c = this.prepareOpts(c), this.id = c.id, c.element.data("select2") !== b && null !== c.element.data("select2") && c.element.data("select2").destroy(), this.container = this.createContainer(), this.liveRegion = a("<span>", {
					role: "status",
					"aria-live": "polite"
				}).addClass("select2-hidden-accessible").appendTo(document.body), this.containerId = "s2id_" + (c.element.attr("id") || "autogen" + g()), this.containerEventName = this.containerId.replace(/([.])/g, "_").replace(/([;&,\-\.\+\*\~':"\!\^#$%@\[\]\(\)=>\|])/g, "\\$1"), this.container.attr("id", this.containerId), this.container.attr("title", c.element.attr("title")), this.body = a("body"), D(this.container, this.opts.element, this.opts.adaptContainerCssClass), this.container.attr("style", c.element.attr("style")), this.container.css(K(c.containerCss, this.opts.element)), this.container.addClass(K(c.containerCssClass, this.opts.element)), this.elementTabIndex = this.opts.element.attr("tabindex"), this.opts.element.data("select2", this).attr("tabindex", "-1").before(this.container).on("click.select2", A), this.container.data("select2", this), this.dropdown = this.container.find(".select2-drop"), D(this.dropdown, this.opts.element, this.opts.adaptDropdownCssClass), this.dropdown.addClass(K(c.dropdownCssClass, this.opts.element)), this.dropdown.data("select2", this), this.dropdown.on("click", A), this.results = d = this.container.find(f), this.search = e = this.container.find("input.select2-input"), this.queryCount = 0, this.resultsPage = 0, this.context = null, this.initContainer(), this.container.on("click", A), v(this.results), this.dropdown.on("mousemove-filtered", f, this.bind(this.highlightUnderEvent)), this.dropdown.on("touchstart touchmove touchend", f, this.bind(function(a) {
					this._touchEvent = !0, this.highlightUnderEvent(a)
				})), this.dropdown.on("touchmove", f, this.bind(this.touchMoved)), this.dropdown.on("touchstart touchend", f, this.bind(this.clearTouchMoved)), this.dropdown.on("click", this.bind(function() {
					this._touchEvent && (this._touchEvent = !1, this.selectHighlighted())
				})), x(80, this.results), this.dropdown.on("scroll-debounced", f, this.bind(this.loadMoreIfNeeded)), a(this.container).on("change", ".select2-input", function(a) {
					a.stopPropagation()
				}), a(this.dropdown).on("change", ".select2-input", function(a) {
					a.stopPropagation()
				}), a.fn.mousewheel && d.mousewheel(function(a, b, c, e) {
					var f = d.scrollTop();
					e > 0 && 0 >= f - e ? (d.scrollTop(0), A(a)) : 0 > e && d.get(0).scrollHeight - d.scrollTop() + e <= d.height() && (d.scrollTop(d.get(0).scrollHeight - d.height()), A(a))
				}), u(e), e.on("keyup-change input paste", this.bind(this.updateResults)), e.on("focus", function() {
					e.addClass("select2-focused")
				}), e.on("blur", function() {
					e.removeClass("select2-focused")
				}), this.dropdown.on("mouseup", f, this.bind(function(b) {
					a(b.target).closest(".select2-result-selectable").length > 0 && (this.highlightUnderEvent(b), this.selectHighlighted(b))
				})), this.dropdown.on("click mouseup mousedown touchstart touchend focusin", function(a) {
					a.stopPropagation()
				}), this.nextSearchTerm = b, a.isFunction(this.opts.initSelection) && (this.initSelection(), this.monitorSource()), null !== c.maximumInputLength && this.search.attr("maxlength", c.maximumInputLength);
				var h = c.element.prop("disabled");
				h === b && (h = !1), this.enable(!h);
				var i = c.element.prop("readonly");
				i === b && (i = !1), this.readonly(i), k = k || q(), this.autofocus = c.element.prop("autofocus"), c.element.prop("autofocus", !1), this.autofocus && this.focus(), this.search.attr("placeholder", c.searchInputPlaceholder)
			},
			destroy: function() {
				var a = this.opts.element,
					c = a.data("select2");
				this.close(), a.length && a[0].detachEvent && a.each(function() {
					this.detachEvent("onpropertychange", this._sync)
				}), this.propertyObserver && (this.propertyObserver.disconnect(), this.propertyObserver = null), this._sync = null, c !== b && (c.container.remove(), c.liveRegion.remove(), c.dropdown.remove(), a.removeClass("select2-offscreen").removeData("select2").off(".select2").prop("autofocus", this.autofocus || !1), this.elementTabIndex ? a.attr({
					tabindex: this.elementTabIndex
				}) : a.removeAttr("tabindex"), a.show()), N.call(this, "container", "liveRegion", "dropdown", "results", "search")
			},
			optionToData: function(a) {
				return a.is("option") ? {
					id: a.prop("value"),
					text: a.text(),
					element: a.get(),
					css: a.attr("class"),
					disabled: a.prop("disabled"),
					locked: r(a.attr("locked"), "locked") || r(a.data("locked"), !0)
				} : a.is("optgroup") ? {
					text: a.attr("label"),
					children: [],
					element: a.get(),
					css: a.attr("class")
				} : void 0
			},
			prepareOpts: function(c) {
				var d, e, f, h, i = this;
				if (d = c.element, "select" === d.get(0).tagName.toLowerCase() && (this.select = e = c.element), e && a.each(["id", "multiple", "ajax", "query", "createSearchChoice", "initSelection", "data", "tags"], function() {
					if (this in c) throw new Error("Option '" + this + "' is not allowed for Select2 when attached to a <select> element.")
				}), c = a.extend({}, {
					populateResults: function(d, e, f) {
						var h, j = this.opts.id,
							k = this.liveRegion;
						h = function(d, e, l) {
							var m, n, o, p, q, r, s, t, u, v;
							d = c.sortResults(d, e, f);
							var w = [];
							for (m = 0, n = d.length; n > m; m += 1) o = d[m], q = o.disabled === !0, p = !q && j(o) !== b, r = o.children && o.children.length > 0, s = a("<li></li>"), s.addClass("select2-results-dept-" + l), s.addClass("select2-result"), s.addClass(p ? "select2-result-selectable" : "select2-result-unselectable"), q && s.addClass("select2-disabled"), r && s.addClass("select2-result-with-children"), s.addClass(i.opts.formatResultCssClass(o)), s.attr("role", "presentation"),t = a(document.createElement("div")), t.addClass("select2-result-label"), t.attr("id", "select2-result-label-" + g()), t.attr("role", "option"), v = c.formatResult(o, t, f, i.opts.escapeMarkup), v !== b && (t.html(v), s.append(t)), r && (u = a("<ul></ul>"), u.addClass("select2-result-sub"), h(o.children, u, l + 1), s.append(u)), s.data("select2-data", o), /*s.attr("title",v),*/ w.push(s[0]);
							e.append(w), k.text(c.formatMatches(d.length))
						}, h(e, d, 0)
					}
				}, a.fn.select2.defaults, c), "function" != typeof c.id && (f = c.id, c.id = function(a) {
					return a[f]
				}), a.isArray(c.element.data("select2Tags"))) {
					if ("tags" in c) throw "tags specified as both an attribute 'data-select2-tags' and in options of Select2 " + c.element.attr("id");
					c.tags = c.element.data("select2Tags")
				}
				if (e ? (c.query = this.bind(function(a) {
					var f, g, h, c = {
						results: [],
						more: !1
					},
						e = a.term;
					h = function(b, c) {
						var d;
						b.is("option") ? a.matcher(e, b.text(), b) && c.push(i.optionToData(b)) : b.is("optgroup") && (d = i.optionToData(b), b.children().each2(function(a, b) {
							h(b, d.children)
						}), d.children.length > 0 && c.push(d))
					}, f = d.children(), this.getPlaceholder() !== b && f.length > 0 && (g = this.getPlaceholderOption(), g && (f = f.not(g))), f.each2(function(a, b) {
						h(b, c.results)
					}), a.callback(c)
				}), c.id = function(a) {
					return a.id
				}) : "query" in c || ("ajax" in c ? (h = c.element.data("ajax-url"), h && h.length > 0 && (c.ajax.url = h), c.query = G.call(c.element, c.ajax)) : "data" in c ? c.query = H(c.data) : "tags" in c && (c.query = I(c.tags), c.createSearchChoice === b && (c.createSearchChoice = function(b) {
					return {
						id: a.trim(b),
						text: a.trim(b)
					}
				}), c.initSelection === b && (c.initSelection = function(b, d) {
					var e = [];
					a(s(b.val(), c.separator)).each(function() {
						var b = {
							id: this,
							text: this
						},
							d = c.tags;
						a.isFunction(d) && (d = d()), a(d).each(function() {
							return r(this.id, b.id) ? (b = this, !1) : void 0
						}), e.push(b)
					}), d(e)
				}))), "function" != typeof c.query) throw "query function not defined for Select2 " + c.element.attr("id");
				if ("top" === c.createSearchChoicePosition) c.createSearchChoicePosition = function(a, b) {
					a.unshift(b)
				};
				else if ("bottom" === c.createSearchChoicePosition) c.createSearchChoicePosition = function(a, b) {
					a.push(b)
				};
				else if ("function" != typeof c.createSearchChoicePosition) throw "invalid createSearchChoicePosition option must be 'top', 'bottom' or a custom function";
				return c
			},
			monitorSource: function() {
				var d, c = this.opts.element,
					e = this;
				c.on("change.select2", this.bind(function() {
					this.opts.element.data("select2-change-triggered") !== !0 && this.initSelection()
				})), this._sync = this.bind(function() {
					var a = c.prop("disabled");
					a === b && (a = !1), this.enable(!a);
					var d = c.prop("readonly");
					d === b && (d = !1), this.readonly(d), D(this.container, this.opts.element, this.opts.adaptContainerCssClass), this.container.addClass(K(this.opts.containerCssClass, this.opts.element)), D(this.dropdown, this.opts.element, this.opts.adaptDropdownCssClass), this.dropdown.addClass(K(this.opts.dropdownCssClass, this.opts.element))
				}), c.length && c[0].attachEvent && c.each(function() {
					this.attachEvent("onpropertychange", e._sync)
				}), d = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver, d !== b && (this.propertyObserver && (delete this.propertyObserver, this.propertyObserver = null), this.propertyObserver = new d(function(b) {
					a.each(b, e._sync)
				}), this.propertyObserver.observe(c.get(0), {
					attributes: !0,
					subtree: !1
				}))
			},
			triggerSelect: function(b) {
				var c = a.Event("select2-selecting", {
					val: this.id(b),
					object: b,
					choice: b
				});
				return this.opts.element.trigger(c), !c.isDefaultPrevented()
			},
			triggerChange: function(b) {
				b = b || {}, b = a.extend({}, b, {
					type: "change",
					val: this.val()
				}), this.opts.element.data("select2-change-triggered", !0), this.opts.element.trigger(b), this.opts.element.data("select2-change-triggered", !1), this.opts.element.click(), this.opts.blurOnChange && this.opts.element.blur()
			},
			isInterfaceEnabled: function() {
				return this.enabledInterface === !0
			},
			enableInterface: function() {
				var a = this._enabled && !this._readonly,
					b = !a;
				return a === this.enabledInterface ? !1 : (this.container.toggleClass("select2-container-disabled", b), this.close(), this.enabledInterface = a, !0)
			},
			enable: function(a) {
				a === b && (a = !0), this._enabled !== a && (this._enabled = a, this.opts.element.prop("disabled", !a), this.enableInterface())
			},
			disable: function() {
				this.enable(!1)
			},
			readonly: function(a) {
				a === b && (a = !1), this._readonly !== a && (this._readonly = a, this.opts.element.prop("readonly", a), this.enableInterface())
			},
			opened: function() {
				return this.container ? this.container.hasClass("select2-dropdown-open") : !1
			},
			positionDropdown: function() {
				var t, u, v, w, x, b = this.dropdown,
					c = this.container.offset(),
					d = this.container.outerHeight(!1),
					e = this.container.outerWidth(!1),
					f = b.outerHeight(!1),
					g = a(window),
					h = g.width(),
					i = g.height(),
					j = g.scrollLeft() + h,
					l = g.scrollTop() + i,
					m = c.top + d,
					n = c.left,
					o = l >= m + f,
					p = c.top - f >= g.scrollTop(),
					q = b.outerWidth(!1),
					r = j >= n + q,
					s = b.hasClass("select2-drop-above");
				s ? (u = !0, !p && o && (v = !0, u = !1)) : (u = !1, !o && p && (v = !0, u = !0)), v && (b.hide(), c = this.container.offset(), d = this.container.outerHeight(!1), e = this.container.outerWidth(!1), f = b.outerHeight(!1), j = g.scrollLeft() + h, l = g.scrollTop() + i, m = c.top + d, n = c.left, q = b.outerWidth(!1), r = j >= n + q, b.show(), this.focusSearch()), this.opts.dropdownAutoWidth ? (x = a(".select2-results", b)[0], b.addClass("select2-drop-auto-width"), b.css("width", ""), q = b.outerWidth(!1) + (x.scrollHeight === x.clientHeight ? 0 : k.width), q > e ? e = q : q = e, f = b.outerHeight(!1), r = j >= n + q) : this.container.removeClass("select2-drop-auto-width"), "static" !== this.body.css("position") && (t = this.body.offset(), m -= t.top, n -= t.left), r || (n = c.left + this.container.outerWidth(!1) - q),
				 w = {
					left: n,
					width: e
				}, u ? (w.top = c.top - f, w.bottom = "auto", this.container.addClass("select2-drop-above"), b.addClass("select2-drop-above")) : (w.top = m, w.bottom = "auto", this.container.removeClass("select2-drop-above"), b.removeClass("select2-drop-above")), w = a.extend(w, K(this.opts.dropdownCss, this.opts.element)), b.css(w)
				if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/7./i)=="7.") 
				{ 
					var wi = b.width();
					b.width(wi*0.99);
				} 
			},
			shouldOpen: function() {
				var b;
				return this.opened() ? !1 : this._enabled === !1 || this._readonly === !0 ? !1 : (b = a.Event("select2-opening"), this.opts.element.trigger(b), !b.isDefaultPrevented())
			},
			clearDropdownAlignmentPreference: function() {
				this.container.removeClass("select2-drop-above"), this.dropdown.removeClass("select2-drop-above")
			},
			open: function() {
				return this.shouldOpen() ? (this.opening(), j.on("mousemove.select2Event", function(a) {
					i.x = a.pageX, i.y = a.pageY
				}), !0) : !1
			},
			opening: function() {
				var f, b = this.containerEventName,
					c = "scroll." + b,
					d = "resize." + b,
					e = "orientationchange." + b;
				this.container.addClass("select2-dropdown-open").addClass("select2-container-active"), this.clearDropdownAlignmentPreference(), this.dropdown[0] !== this.body.children().last()[0] && this.dropdown.detach().appendTo(this.body), f = a("#select2-drop-mask"), 0 == f.length && (f = a(document.createElement("div")), f.attr("id", "select2-drop-mask").attr("class", "select2-drop-mask"), f.hide(), f.appendTo(this.body), f.on("mousedown touchstart click", function(b) {
					n(f);
					var d, c = a("#select2-drop");
					c.length > 0 && (d = c.data("select2"), d.opts.selectOnBlur && d.selectHighlighted({
						noFocus: !0
					}), d.close(), b.preventDefault(), b.stopPropagation())
				})), this.dropdown.prev()[0] !== f[0] && this.dropdown.before(f), a("#select2-drop").removeAttr("id"), this.dropdown.attr("id", "select2-drop"), f.show(), this.positionDropdown(), this.dropdown.show(), this.positionDropdown(), this.dropdown.addClass("select2-drop-active");
				var g = this;
				this.container.parents().add(window).each(function() {
					a(this).on(d + " " + c + " " + e, function() {
						g.opened() && g.positionDropdown()
					})
				})
			},
			close: function() {
				if (this.opened()) {
					var b = this.containerEventName,
						c = "scroll." + b,
						d = "resize." + b,
						e = "orientationchange." + b;
					this.container.parents().add(window).each(function() {
						a(this).off(c).off(d).off(e)
					}), this.clearDropdownAlignmentPreference(), a("#select2-drop-mask").hide(), this.dropdown.removeAttr("id"), this.dropdown.hide(), this.container.removeClass("select2-dropdown-open").removeClass("select2-container-active"), this.results.empty(), j.off("mousemove.select2Event"), this.clearSearch(), this.search.removeClass("select2-active"), this.opts.element.trigger(a.Event("select2-close"))
				}
			},
			externalSearch: function(a) {
				this.open(), this.search.val(a), this.updateResults(!1)
			},
			clearSearch: function() {},
			getMaximumSelectionSize: function() {
				return K(this.opts.maximumSelectionSize, this.opts.element)
			},
			ensureHighlightVisible: function() {
				var c, d, e, f, g, h, i, j, b = this.results;
				if (d = this.highlight(), !(0 > d)) {
					if (0 == d) return b.scrollTop(0), void 0;
					c = this.findHighlightableChoices().find(".select2-result-label"), e = a(c[d]), j = (e.offset() || {}).top || 0, f = j + e.outerHeight(!0), d === c.length - 1 && (i = b.find("li.select2-more-results"), i.length > 0 && (f = i.offset().top + i.outerHeight(!0))), g = b.offset().top + b.outerHeight(!0), f > g && b.scrollTop(b.scrollTop() + (f - g)), h = j - b.offset().top, 0 > h && "none" != e.css("display") && b.scrollTop(b.scrollTop() + h)
				}
			},
			findHighlightableChoices: function() {
				return this.results.find(".select2-result-selectable:not(.select2-disabled):not(.select2-selected)")
			},
			moveHighlight: function(b) {
				for (var c = this.findHighlightableChoices(), d = this.highlight(); d > -1 && d < c.length;) {
					d += b;
					var e = a(c[d]);
					if (e.hasClass("select2-result-selectable") && !e.hasClass("select2-disabled") && !e.hasClass("select2-selected")) {
						this.highlight(d);
						break
					}
				}
			},
			highlight: function(b) {
				var d, e, c = this.findHighlightableChoices();
				return 0 === arguments.length ? p(c.filter(".select2-highlighted")[0], c.get()) : (b >= c.length && (b = c.length - 1), 0 > b && (b = 0), this.removeHighlight(), d = a(c[b]), d.addClass("select2-highlighted"), this.search.attr("aria-activedescendant", d.find(".select2-result-label").attr("id")), this.ensureHighlightVisible(), this.liveRegion.text(d.text()), e = d.data("select2-data"), e && this.opts.element.trigger({
					type: "select2-highlight",
					val: this.id(e),
					choice: e
				}), void 0)
			},
			removeHighlight: function() {
				this.results.find(".select2-highlighted").removeClass("select2-highlighted")
			},
			touchMoved: function() {
				this._touchMoved = !0
			},
			clearTouchMoved: function() {
				this._touchMoved = !1
			},
			countSelectableResults: function() {
				return this.findHighlightableChoices().length
			},
			highlightUnderEvent: function(b) {
				var c = a(b.target).closest(".select2-result-selectable");
				if (c.length > 0 && !c.is(".select2-highlighted")) {
					var d = this.findHighlightableChoices();
					this.highlight(d.index(c))
				} else 0 == c.length && this.removeHighlight()
			},
			loadMoreIfNeeded: function() {
				var c, a = this.results,
					b = a.find("li.select2-more-results"),
					d = this.resultsPage + 1,
					e = this,
					f = this.search.val(),
					g = this.context;
				0 !== b.length && (c = b.offset().top - a.offset().top - a.height(), c <= this.opts.loadMorePadding && (b.addClass("select2-active"), this.opts.query({
					element: this.opts.element,
					term: f,
					page: d,
					context: g,
					matcher: this.opts.matcher,
					callback: this.bind(function(c) {
						e.opened() && (e.opts.populateResults.call(this, a, c.results, {
							term: f,
							page: d,
							context: g
						}), e.postprocessResults(c, !1, !1), c.more === !0 ? (b.detach().appendTo(a).text(K(e.opts.formatLoadMore, e.opts.element, d + 1)), window.setTimeout(function() {
							e.loadMoreIfNeeded()
						}, 10)) : b.remove(), e.positionDropdown(), e.resultsPage = d, e.context = c.context, this.opts.element.trigger({
							type: "select2-loaded",
							items: c
						}))
					})
				})))
			},
			tokenize: function() {},
			updateResults: function(c) {
				function m() {
					d.removeClass("select2-active"), h.positionDropdown(), e.find(".select2-no-results,.select2-selection-limit,.select2-searching").length ? h.liveRegion.text(e.text()) : h.liveRegion.text(h.opts.formatMatches(e.find(".select2-result-selectable").length))
				}
				function n(a) {
					e.html(a), m()
				}
				var g, i, l, d = this.search,
					e = this.results,
					f = this.opts,
					h = this,
					j = d.val(),
					k = a.data(this.container, "select2-last-term");
				if ((c === !0 || !k || !r(j, k)) && (a.data(this.container, "select2-last-term", j), c === !0 || this.showSearchInput !== !1 && this.opened())) {
					l = ++this.queryCount;
					var o = this.getMaximumSelectionSize();
					if (o >= 1 && (g = this.data(), a.isArray(g) && g.length >= o && J(f.formatSelectionTooBig, "formatSelectionTooBig"))) return n("<li class='select2-selection-limit'>" + K(f.formatSelectionTooBig, f.element, o) + "</li>"), void 0;
					if (d.val().length < f.minimumInputLength) return J(f.formatInputTooShort, "formatInputTooShort") ? n("<li class='select2-no-results'>" + K(f.formatInputTooShort, f.element, d.val(), f.minimumInputLength) + "</li>") : n(""), c && this.showSearch && this.showSearch(!0), void 0;
					if (f.maximumInputLength && d.val().length > f.maximumInputLength) return J(f.formatInputTooLong, "formatInputTooLong") ? n("<li class='select2-no-results'>" + K(f.formatInputTooLong, f.element, d.val(), f.maximumInputLength) + "</li>") : n(""), void 0;
					f.formatSearching && 0 === this.findHighlightableChoices().length && n("<li class='select2-searching'>" + K(f.formatSearching, f.element) + "</li>"), d.addClass("select2-active"), this.removeHighlight(), i = this.tokenize(), i != b && null != i && d.val(i), this.resultsPage = 1, f.query({
						element: f.element,
						term: d.val(),
						page: this.resultsPage,
						context: null,
						matcher: f.matcher,
						callback: this.bind(function(g) {
							var i;
							if (l == this.queryCount) {
								if (!this.opened()) return this.search.removeClass("select2-active"), void 0;
								if (this.context = g.context === b ? null : g.context, this.opts.createSearchChoice && "" !== d.val() && (i = this.opts.createSearchChoice.call(h, d.val(), g.results), i !== b && null !== i && h.id(i) !== b && null !== h.id(i) && 0 === a(g.results).filter(function() {
									return r(h.id(this), h.id(i))
								}).length && this.opts.createSearchChoicePosition(g.results, i)), 0 === g.results.length && J(f.formatNoMatches, "formatNoMatches")) return n("<li class='select2-no-results'>" + K(f.formatNoMatches, f.element, d.val()) + "</li>"), void 0;
								e.empty(), h.opts.populateResults.call(this, e, g.results, {
									term: d.val(),
									page: this.resultsPage,
									context: null
								}), g.more === !0 && J(f.formatLoadMore, "formatLoadMore") && (e.append("<li class='select2-more-results'>" + f.escapeMarkup(K(f.formatLoadMore, f.element, this.resultsPage)) + "</li>"), window.setTimeout(function() {
									h.loadMoreIfNeeded()
								}, 10)), this.postprocessResults(g, c), m(), this.opts.element.trigger({
									type: "select2-loaded",
									items: g
								})
							}
						})
					})
				}
			},
			cancel: function() {
				this.close()
			},
			blur: function() {
				this.opts.selectOnBlur && this.selectHighlighted({
					noFocus: !0
				}), this.close(), this.container.removeClass("select2-container-active"), this.search[0] === document.activeElement && this.search.blur(), this.clearSearch(), this.selection.find(".select2-search-choice-focus").removeClass("select2-search-choice-focus")
			},
			focusSearch: function() {
				y(this.search)
			},
			selectHighlighted: function(a) {
				if (this._touchMoved) return this.clearTouchMoved(), void 0;
				var b = this.highlight(),
					c = this.results.find(".select2-highlighted"),
					d = c.closest(".select2-result").data("select2-data");
				d ? (this.highlight(b), this.onSelect(d, a)) : a && a.noFocus && this.close()
			},
			getPlaceholder: function() {
				var a;
				return this.opts.element.attr("placeholder") || this.opts.element.attr("data-placeholder") || this.opts.element.data("placeholder") || this.opts.placeholder || ((a = this.getPlaceholderOption()) !== b ? a.text() : b)
			},
			getPlaceholderOption: function() {
				if (this.select) {
					var c = this.select.children("option").first();
					if (this.opts.placeholderOption !== b) return "first" === this.opts.placeholderOption && c || "function" == typeof this.opts.placeholderOption && this.opts.placeholderOption(this.select);
					if ("" === a.trim(c.text()) && "" === c.val()) return c
				}
			},
			initContainerWidth: function() {
				function c() {
					var c, d, e, f, g, h;
					if ("off" === this.opts.width) return null;
					if ("element" === this.opts.width) return 0 === this.opts.element.outerWidth(!1) ? "auto" : this.opts.element.outerWidth(!1) + "px";
					if ("copy" === this.opts.width || "resolve" === this.opts.width) {
						if (c = this.opts.element.attr("style"), c !== b) for (d = c.split(";"), f = 0, g = d.length; g > f; f += 1) if (h = d[f].replace(/\s/g, ""), e = h.match(/^width:(([-+]?([0-9]*\.)?[0-9]+)(px|em|ex|%|in|cm|mm|pt|pc))/i), null !== e && e.length >= 1) return e[1];
						return "resolve" === this.opts.width ? (c = this.opts.element.css("width"), c.indexOf("%") > 0 ? c : 0 === this.opts.element.outerWidth(!1) ? "auto" : this.opts.element.outerWidth(!1) + "px") : null
					}
					return a.isFunction(this.opts.width) ? this.opts.width() : this.opts.width
				}
				var d = c.call(this);
				null !== d && this.container.css("width", d)
			}
		}), e = O(d, {
			createContainer: function() {
				var b = a(document.createElement("div")).attr({
					"class": "select2-container"
				}).html(["<a href='javascript:void(0)' class='select2-choice' tabindex='-1'>", "   <span class='select2-chosen'>&#160;</span><abbr class='select2-search-choice-close'></abbr>", "   <span class='select2-arrow' role='presentation'><b role='presentation'></b></span>", "</a>", "<label for='' class='select2-offscreen'></label>", "<input class='select2-focusser select2-offscreen' type='text' aria-haspopup='true' role='button' />", "<div class='select2-drop select2-display-none'>", "   <div class='select2-search'>", "       <label for='' class='select2-offscreen'></label>", "       <input type='text' autocomplete='off' autocorrect='off' autocapitalize='off' spellcheck='false' class='select2-input' role='combobox' aria-expanded='true'", "       aria-autocomplete='list' />", "   </div>", "   <ul class='select2-results' role='listbox'>", "   </ul>", "</div>"].join(""));
				return b
			},
			enableInterface: function() {
				this.parent.enableInterface.apply(this, arguments) && this.focusser.prop("disabled", !this.isInterfaceEnabled())
			},
			opening: function() {
				var c, d, e;
				this.opts.minimumResultsForSearch >= 0 && this.showSearch(!0), this.parent.opening.apply(this, arguments), this.showSearchInput !== !1 && this.search.val(this.focusser.val()), this.opts.shouldFocusInput(this) && (this.search.focus(), c = this.search.get(0), c.createTextRange ? (d = c.createTextRange(), d.collapse(!1), d.select()) : c.setSelectionRange && (e = this.search.val().length, c.setSelectionRange(e, e))), "" === this.search.val() && this.nextSearchTerm != b && (this.search.val(this.nextSearchTerm), this.search.select()), this.focusser.prop("disabled", !0).val(""), this.updateResults(!0), this.opts.element.trigger(a.Event("select2-open"))
			},
			close: function() {
				this.opened() && (this.parent.close.apply(this, arguments), this.focusser.prop("disabled", !1), this.opts.shouldFocusInput(this) && this.focusser.focus())
			},
			focus: function() {
				this.opened() ? this.close() : (this.focusser.prop("disabled", !1), this.opts.shouldFocusInput(this) && this.focusser.focus())
			},
			isFocused: function() {
				return this.container.hasClass("select2-container-active")
			},
			cancel: function() {
				this.parent.cancel.apply(this, arguments), this.focusser.prop("disabled", !1), this.opts.shouldFocusInput(this) && this.focusser.focus()
			},
			destroy: function() {
				a("label[for='" + this.focusser.attr("id") + "']").attr("for", this.opts.element.attr("id")), this.parent.destroy.apply(this, arguments), N.call(this, "selection", "focusser")
			},
			initContainer: function() {
				var b, h, d = this.container,
					e = this.dropdown,
					f = g();
				this.opts.minimumResultsForSearch < 0 ? this.showSearch(!1) : this.showSearch(!0), this.selection = b = d.find(".select2-choice"), this.focusser = d.find(".select2-focusser"), b.find(".select2-chosen").attr("id", "select2-chosen-" + f), this.focusser.attr("aria-labelledby", "select2-chosen-" + f), this.results.attr("id", "select2-results-" + f), this.search.attr("aria-owns", "select2-results-" + f), this.focusser.attr("id", "s2id_autogen" + f), h = a("label[for='" + this.opts.element.attr("id") + "']"), this.focusser.prev().text(h.text()).attr("for", this.focusser.attr("id"));
				var i = this.opts.element.attr("title");
				this.opts.element.attr("title", i || h.text()), this.focusser.attr("tabindex", this.elementTabIndex), this.search.attr("id", this.focusser.attr("id") + "_search"), this.search.prev().text(a("label[for='" + this.focusser.attr("id") + "']").text()).attr("for", this.search.attr("id")), this.search.on("keydown", this.bind(function(a) {
					if (this.isInterfaceEnabled()) {
						if (a.which === c.PAGE_UP || a.which === c.PAGE_DOWN) return A(a), void 0;
						switch (a.which) {
						case c.UP:
						case c.DOWN:
							return this.moveHighlight(a.which === c.UP ? -1 : 1), A(a), void 0;
						case c.ENTER:
							return this.selectHighlighted(), A(a), void 0;
						case c.TAB:
							return this.selectHighlighted({
								noFocus: !0
							}), void 0;
						case c.ESC:
							return this.cancel(a), A(a), void 0
						}
					}
				})), this.search.on("blur", this.bind(function() {
					document.activeElement === this.body.get(0) && window.setTimeout(this.bind(function() {
						this.opened() && this.search.focus()
					}), 0)
				})), this.focusser.on("keydown", this.bind(function(a) {
					if (this.isInterfaceEnabled() && a.which !== c.TAB && !c.isControl(a) && !c.isFunctionKey(a) && a.which !== c.ESC) {
						if (this.opts.openOnEnter === !1 && a.which === c.ENTER) return A(a), void 0;
						if (a.which == c.DOWN || a.which == c.UP || a.which == c.ENTER && this.opts.openOnEnter) {
							if (a.altKey || a.ctrlKey || a.shiftKey || a.metaKey) return;
							return this.open(), A(a), void 0
						}
						return a.which == c.DELETE || a.which == c.BACKSPACE ? (this.opts.allowClear && this.clear(), A(a), void 0) : void 0
					}
				})), u(this.focusser), this.focusser.on("keyup-change input", this.bind(function(a) {
					if (this.opts.minimumResultsForSearch >= 0) {
						if (a.stopPropagation(), this.opened()) return;
						this.open()
					}
				})), b.on("mousedown touchstart", "abbr", this.bind(function(a) {
					this.isInterfaceEnabled() && (this.clear(), B(a), this.close(), this.selection.focus())
				})), b.on("mousedown touchstart", this.bind(function(c) {
					n(b), this.container.hasClass("select2-container-active") || this.opts.element.trigger(a.Event("select2-focus")), this.opened() ? this.close() : this.isInterfaceEnabled() && this.open(), A(c)
				})), e.on("mousedown touchstart", this.bind(function() {
					this.opts.shouldFocusInput(this) && this.search.focus()
				})), b.on("focus", this.bind(function(a) {
					A(a)
				})), this.focusser.on("focus", this.bind(function() {
					this.container.hasClass("select2-container-active") || this.opts.element.trigger(a.Event("select2-focus")), this.container.addClass("select2-container-active")
				})).on("blur", this.bind(function() {
					this.opened() || (this.container.removeClass("select2-container-active"), this.opts.element.trigger(a.Event("select2-blur")))
				})), this.search.on("focus", this.bind(function() {
					this.container.hasClass("select2-container-active") || this.opts.element.trigger(a.Event("select2-focus")), this.container.addClass("select2-container-active")
				})), this.initContainerWidth(), this.opts.element.addClass("select2-offscreen"), this.setPlaceholder()
			},
			clear: function(b) {
				var c = this.selection.data("select2-data");
				if (c) {
					var d = a.Event("select2-clearing");
					if (this.opts.element.trigger(d), d.isDefaultPrevented()) return;
					var e = this.getPlaceholderOption();
					this.opts.element.val(e ? e.val() : ""), this.selection.find(".select2-chosen").empty(), this.selection.removeData("select2-data"), this.setPlaceholder(), b !== !1 && (this.opts.element.trigger({
						type: "select2-removed",
						val: this.id(c),
						choice: c
					}), this.triggerChange({
						removed: c
					}))
				}
			},
			initSelection: function() {
				if (this.isPlaceholderOptionSelected()) this.updateSelection(null), this.close(), this.setPlaceholder();
				else {
					var c = this;
					this.opts.initSelection.call(null, this.opts.element, function(a) {
						a !== b && null !== a && (c.updateSelection(a), c.close(), c.setPlaceholder(), c.nextSearchTerm = c.opts.nextSearchTerm(a, c.search.val()))
					})
				}
			},
			isPlaceholderOptionSelected: function() {
				var a;
				return this.getPlaceholder() === b ? !1 : (a = this.getPlaceholderOption()) !== b && a.prop("selected") || "" === this.opts.element.val() || this.opts.element.val() === b || null === this.opts.element.val()
			},
			prepareOpts: function() {
				var b = this.parent.prepareOpts.apply(this, arguments),
					c = this;
				return "select" === b.element.get(0).tagName.toLowerCase() ? b.initSelection = function(a, b) {
					var d = a.find("option").filter(function() {
						return this.selected && !this.disabled
					});
					b(c.optionToData(d))
				} : "data" in b && (b.initSelection = b.initSelection ||
				function(c, d) {
					var e = c.val(),
						f = null;
					b.query({
						matcher: function(a, c, d) {
							var g = r(e, b.id(d));
							return g && (f = d), g
						},
						callback: a.isFunction(d) ?
						function() {
							d(f)
						} : a.noop
					})
				}), b
			},
			getPlaceholder: function() {
				return this.select && this.getPlaceholderOption() === b ? b : this.parent.getPlaceholder.apply(this, arguments)
			},
			setPlaceholder: function() {
				var a = this.getPlaceholder();
				if (this.isPlaceholderOptionSelected() && a !== b) {
					if (this.select && this.getPlaceholderOption() === b) return;
					this.selection.find(".select2-chosen").html(this.opts.escapeMarkup(a)), this.selection.addClass("select2-default"), this.container.removeClass("select2-allowclear")
				}
			},
			postprocessResults: function(a, b, c) {
				var d = 0,
					e = this;
				if (this.findHighlightableChoices().each2(function(a, b) {
					return r(e.id(b.data("select2-data")), e.opts.element.val()) ? (d = a, !1) : void 0
				}), c !== !1 && (b === !0 && d >= 0 ? this.highlight(d) : this.highlight(0)), b === !0) {
					var g = this.opts.minimumResultsForSearch;
					g >= 0 && this.showSearch(L(a.results) >= g)
				}
			},
			showSearch: function(b) {
				this.showSearchInput !== b && (this.showSearchInput = b, this.dropdown.find(".select2-search").toggleClass("select2-search-hidden", !b), this.dropdown.find(".select2-search").toggleClass("select2-offscreen", !b), a(this.dropdown, this.container).toggleClass("select2-with-searchbox", b))
			},
			onSelect: function(a, b) {
				if (this.triggerSelect(a)) {
					var c = this.opts.element.val(),
						d = this.data();
					this.opts.element.val(this.id(a)), this.updateSelection(a), this.opts.element.trigger({
						type: "select2-selected",
						val: this.id(a),
						choice: a
					}), this.nextSearchTerm = this.opts.nextSearchTerm(a, this.search.val()), this.close(), b && b.noFocus || !this.opts.shouldFocusInput(this) || this.focusser.focus(), r(c, this.id(a)) || this.triggerChange({
						added: a,
						removed: d
					})
				}
			},
			updateSelection: function(a) {
				var d, e, c = this.selection.find(".select2-chosen");
				this.selection.data("select2-data", a), c.empty(), null !== a && (d = this.opts.formatSelection(a, c, this.opts.escapeMarkup)), d !== b && c.append(d), e = this.opts.formatSelectionCssClass(a, c), e !== b && c.addClass(e), this.selection.removeClass("select2-default"), this.opts.allowClear && this.getPlaceholder() !== b && this.container.addClass("select2-allowclear");
				this.selection.attr("title",d);
			},
			val: function() {
				var a, c = !1,
					d = null,
					e = this,
					f = this.data();
				if (0 === arguments.length) return this.opts.element.val();
				if (a = arguments[0], arguments.length > 1 && (c = arguments[1]), this.select) this.select.val(a).find("option").filter(function() {
					return this.selected
				}).each2(function(a, b) {
					return d = e.optionToData(b), !1
				}), this.updateSelection(d), this.setPlaceholder(), c && this.triggerChange({
					added: d,
					removed: f
				});
				else {
					if (!a && 0 !== a) return this.clear(c), void 0;
					if (this.opts.initSelection === b) throw new Error("cannot call val() if initSelection() is not defined");
					this.opts.element.val(a), this.opts.initSelection(this.opts.element, function(a) {
						e.opts.element.val(a ? e.id(a) : ""), e.updateSelection(a), e.setPlaceholder(), c && e.triggerChange({
							added: a,
							removed: f
						})
					})
				}
			},
			clearSearch: function() {
				this.search.val(""), this.focusser.val("")
			},
			data: function(a) {
				var c, d = !1;
				return 0 === arguments.length ? (c = this.selection.data("select2-data"), c == b && (c = null), c) : (arguments.length > 1 && (d = arguments[1]), a ? (c = this.data(), this.opts.element.val(a ? this.id(a) : ""), this.updateSelection(a), d && this.triggerChange({
					added: a,
					removed: c
				})) : this.clear(d), void 0)
			}
		}), f = O(d, {
			createContainer: function() {
				var b = a(document.createElement("div")).attr({
					"class": "select2-container select2-container-multi"
				}).html(["<ul class='select2-choices'>", "  <li class='select2-search-field'>", "    <label for='' class='select2-offscreen'></label>", "    <input type='text' autocomplete='off' autocorrect='off' autocapitalize='off' spellcheck='false' class='select2-input'>", "  </li>", "</ul>", "<div class='select2-drop select2-drop-multi select2-display-none'>", "   <ul class='select2-results'>", "   </ul>", "</div>"].join(""));
				return b
			},
			prepareOpts: function() {
				var b = this.parent.prepareOpts.apply(this, arguments),
					c = this;
				return "select" === b.element.get(0).tagName.toLowerCase() ? b.initSelection = function(a, b) {
					var d = [];
					a.find("option").filter(function() {
						return this.selected && !this.disabled
					}).each2(function(a, b) {
						d.push(c.optionToData(b))
					}), b(d)
				} : "data" in b && (b.initSelection = b.initSelection ||
				function(c, d) {
					var e = s(c.val(), b.separator),
						f = [];
					b.query({
						matcher: function(c, d, g) {
							var h = a.grep(e, function(a) {
								return r(a, b.id(g))
							}).length;
							return h && f.push(g), h
						},
						callback: a.isFunction(d) ?
						function() {
							for (var a = [], c = 0; c < e.length; c++) for (var g = e[c], h = 0; h < f.length; h++) {
								var i = f[h];
								if (r(g, b.id(i))) {
									a.push(i), f.splice(h, 1);
									break
								}
							}
							d(a)
						} : a.noop
					})
				}), b
			},
			selectChoice: function(a) {
				var b = this.container.find(".select2-search-choice-focus");
				b.length && a && a[0] == b[0] || (b.length && this.opts.element.trigger("choice-deselected", b), b.removeClass("select2-search-choice-focus"), a && a.length && (this.close(), a.addClass("select2-search-choice-focus"), this.opts.element.trigger("choice-selected", a)))
			},
			destroy: function() {
				a("label[for='" + this.search.attr("id") + "']").attr("for", this.opts.element.attr("id")), this.parent.destroy.apply(this, arguments), N.call(this, "searchContainer", "selection")
			},
			initContainer: function() {
				var d, b = ".select2-choices";
				this.searchContainer = this.container.find(".select2-search-field"), this.selection = d = this.container.find(b);
				var e = this;
				this.selection.on("click", ".select2-search-choice:not(.select2-locked)", function() {
					e.search[0].focus(), e.selectChoice(a(this))
				}), this.search.attr("id", "s2id_autogen" + g()), this.search.prev().text(a("label[for='" + this.opts.element.attr("id") + "']").text()).attr("for", this.search.attr("id")), this.search.on("input paste", this.bind(function() {
					this.search.attr("placeholder") && 0 == this.search.val().length || this.isInterfaceEnabled() && (this.opened() || this.open())
				})), this.search.attr("tabindex", this.elementTabIndex), this.keydowns = 0, this.search.on("keydown", this.bind(function(a) {
					if (this.isInterfaceEnabled()) {
						++this.keydowns;
						var b = d.find(".select2-search-choice-focus"),
							e = b.prev(".select2-search-choice:not(.select2-locked)"),
							f = b.next(".select2-search-choice:not(.select2-locked)"),
							g = z(this.search);
						if (b.length && (a.which == c.LEFT || a.which == c.RIGHT || a.which == c.BACKSPACE || a.which == c.DELETE || a.which == c.ENTER)) {
							var h = b;
							return a.which == c.LEFT && e.length ? h = e : a.which == c.RIGHT ? h = f.length ? f : null : a.which === c.BACKSPACE ? this.unselect(b.first()) && (this.search.width(10), h = e.length ? e : f) : a.which == c.DELETE ? this.unselect(b.first()) && (this.search.width(10), h = f.length ? f : null) : a.which == c.ENTER && (h = null), this.selectChoice(h), A(a), h && h.length || this.open(), void 0
						}
						if ((a.which === c.BACKSPACE && 1 == this.keydowns || a.which == c.LEFT) && 0 == g.offset && !g.length) return this.selectChoice(d.find(".select2-search-choice:not(.select2-locked)").last()), A(a), void 0;
						if (this.selectChoice(null), this.opened()) switch (a.which) {
						case c.UP:
						case c.DOWN:
							return this.moveHighlight(a.which === c.UP ? -1 : 1), A(a), void 0;
						case c.ENTER:
							return this.selectHighlighted(), A(a), void 0;
						case c.TAB:
							return this.selectHighlighted({
								noFocus: !0
							}), this.close(), void 0;
						case c.ESC:
							return this.cancel(a), A(a), void 0
						}
						if (a.which !== c.TAB && !c.isControl(a) && !c.isFunctionKey(a) && a.which !== c.BACKSPACE && a.which !== c.ESC) {
							if (a.which === c.ENTER) {
								if (this.opts.openOnEnter === !1) return;
								if (a.altKey || a.ctrlKey || a.shiftKey || a.metaKey) return
							}
							this.open(), (a.which === c.PAGE_UP || a.which === c.PAGE_DOWN) && A(a), a.which === c.ENTER && A(a)
						}
					}
				})), this.search.on("keyup", this.bind(function() {
					this.keydowns = 0, this.resizeSearch()
				})), this.search.on("blur", this.bind(function(b) {
					this.container.removeClass("select2-container-active"), this.search.removeClass("select2-focused"), this.selectChoice(null), this.opened() || this.clearSearch(), b.stopImmediatePropagation(), this.opts.element.trigger(a.Event("select2-blur"))
				})), this.container.on("click", b, this.bind(function(b) {
					this.isInterfaceEnabled() && (a(b.target).closest(".select2-search-choice").length > 0 || (this.selectChoice(null), this.clearPlaceholder(), this.container.hasClass("select2-container-active") || this.opts.element.trigger(a.Event("select2-focus")), this.open(), this.focusSearch(), b.preventDefault()))
				})), this.container.on("focus", b, this.bind(function() {
					this.isInterfaceEnabled() && (this.container.hasClass("select2-container-active") || this.opts.element.trigger(a.Event("select2-focus")), this.container.addClass("select2-container-active"), this.dropdown.addClass("select2-drop-active"), this.clearPlaceholder())
				})), this.initContainerWidth(), this.opts.element.addClass("select2-offscreen"), this.clearSearch()
			},
			enableInterface: function() {
				this.parent.enableInterface.apply(this, arguments) && this.search.prop("disabled", !this.isInterfaceEnabled())
			},
			initSelection: function() {
				if ("" === this.opts.element.val() && "" === this.opts.element.text() && (this.updateSelection([]), this.close(), this.clearSearch()), this.select || "" !== this.opts.element.val()) {
					var c = this;
					this.opts.initSelection.call(null, this.opts.element, function(a) {
						a !== b && null !== a && (c.updateSelection(a), c.close(), c.clearSearch())
					})
				}
			},
			clearSearch: function() {
				var a = this.getPlaceholder(),
					c = this.getMaxSearchWidth();
				a !== b && 0 === this.getVal().length && this.search.hasClass("select2-focused") === !1 ? (this.search.val(a).addClass("select2-default"), this.search.width(c > 0 ? c : this.container.css("width"))) : this.search.val("").width(10)
			},
			clearPlaceholder: function() {
				this.search.hasClass("select2-default") && this.search.val("").removeClass("select2-default")
			},
			opening: function() {
				this.clearPlaceholder(), this.resizeSearch(), this.parent.opening.apply(this, arguments), this.focusSearch(), "" === this.search.val() && this.nextSearchTerm != b && (this.search.val(this.nextSearchTerm), this.search.select()), this.updateResults(!0), this.opts.shouldFocusInput(this) && this.search.focus(), this.opts.element.trigger(a.Event("select2-open"))
			},
			close: function() {
				this.opened() && this.parent.close.apply(this, arguments)
			},
			focus: function() {
				this.close(), this.search.focus()
			},
			isFocused: function() {
				return this.search.hasClass("select2-focused")
			},
			updateSelection: function(b) {
				var c = [],
					d = [],
					e = this;
				a(b).each(function() {
					p(e.id(this), c) < 0 && (c.push(e.id(this)), d.push(this))
				}), b = d, this.selection.find(".select2-search-choice").remove(), a(b).each(function() {
					e.addSelectedChoice(this)
				}), e.postprocessResults()
			},
			tokenize: function() {
				var a = this.search.val();
				a = this.opts.tokenizer.call(this, a, this.data(), this.bind(this.onSelect), this.opts), null != a && a != b && (this.search.val(a), a.length > 0 && this.open())
			},
			onSelect: function(a, c) {
				this.triggerSelect(a) && (this.addSelectedChoice(a), this.opts.element.trigger({
					type: "selected",
					val: this.id(a),
					choice: a
				}), this.nextSearchTerm = this.opts.nextSearchTerm(a, this.search.val()), this.clearSearch(), this.updateResults(), (this.select || !this.opts.closeOnSelect) && this.postprocessResults(a, !1, this.opts.closeOnSelect === !0), this.opts.closeOnSelect ? (this.close(), this.search.width(10)) : this.countSelectableResults() > 0 ? (this.search.width(10), this.resizeSearch(), this.getMaximumSelectionSize() > 0 && this.val().length >= this.getMaximumSelectionSize() ? this.updateResults(!0) : this.nextSearchTerm != b && (this.search.val(this.nextSearchTerm), this.updateResults(), this.search.select()), this.positionDropdown()) : (this.close(), this.search.width(10)), this.triggerChange({
					added: a
				}), c && c.noFocus || this.focusSearch())
			},
			cancel: function() {
				this.close(), this.focusSearch()
			},
			addSelectedChoice: function(c) {
				var j, k, d = !c.locked,
					e = a("<li class='select2-search-choice'>    <div></div>    <a href='#' class='select2-search-choice-close' tabindex='-1'></a></li>"),
					f = a("<li class='select2-search-choice select2-locked'><div></div></li>"),
					g = d ? e : f,
					h = this.id(c),
					i = this.getVal();
				j = this.opts.formatSelection(c, g.find("div"), this.opts.escapeMarkup), j != b && g.find("div").replaceWith("<div>" + j + "</div>"), k = this.opts.formatSelectionCssClass(c, g.find("div")), k != b && g.addClass(k), d && g.find(".select2-search-choice-close").on("mousedown", A).on("click dblclick", this.bind(function(b) {
					this.isInterfaceEnabled() && (this.unselect(a(b.target)), this.selection.find(".select2-search-choice-focus").removeClass("select2-search-choice-focus"), A(b), this.close(), this.focusSearch())
				})).on("focus", this.bind(function() {
					this.isInterfaceEnabled() && (this.container.addClass("select2-container-active"), this.dropdown.addClass("select2-drop-active"))
				})), g.data("select2-data", c), g.insertBefore(this.searchContainer), i.push(h), this.setVal(i)
			},
			unselect: function(b) {
				var d, e, c = this.getVal();
				if (b = b.closest(".select2-search-choice"), 0 === b.length) throw "Invalid argument: " + b + ". Must be .select2-search-choice";
				if (d = b.data("select2-data")) {
					var f = a.Event("select2-removing");
					if (f.val = this.id(d), f.choice = d, this.opts.element.trigger(f), f.isDefaultPrevented()) return !1;
					for (;
					(e = p(this.id(d), c)) >= 0;) c.splice(e, 1), this.setVal(c), this.select && this.postprocessResults();
					return b.remove(), this.opts.element.trigger({
						type: "select2-removed",
						val: this.id(d),
						choice: d
					}), this.triggerChange({
						removed: d
					}), !0
				}
			},
			postprocessResults: function(a, b, c) {
				var d = this.getVal(),
					e = this.results.find(".select2-result"),
					f = this.results.find(".select2-result-with-children"),
					g = this;
				e.each2(function(a, b) {
					var c = g.id(b.data("select2-data"));
					p(c, d) >= 0 && (b.addClass("select2-selected"), b.find(".select2-result-selectable").addClass("select2-selected"))
				}), f.each2(function(a, b) {
					b.is(".select2-result-selectable") || 0 !== b.find(".select2-result-selectable:not(.select2-selected)").length || b.addClass("select2-selected")
				}), -1 == this.highlight() && c !== !1 && g.highlight(0), !this.opts.createSearchChoice && !e.filter(".select2-result:not(.select2-selected)").length > 0 && (!a || a && !a.more && 0 === this.results.find(".select2-no-results").length) && J(g.opts.formatNoMatches, "formatNoMatches") && this.results.append("<li class='select2-no-results'>" + K(g.opts.formatNoMatches, g.opts.element, g.search.val()) + "</li>")
			},
			getMaxSearchWidth: function() {
				return this.selection.width() - t(this.search)
			},
			resizeSearch: function() {
				var a, b, c, d, e, f = t(this.search);
				a = C(this.search) + 10, b = this.search.offset().left, c = this.selection.width(), d = this.selection.offset().left, e = c - (b - d) - f, a > e && (e = c - f), 40 > e && (e = c - f), 0 >= e && (e = a), this.search.width(Math.floor(e))
			},
			getVal: function() {
				var a;
				return this.select ? (a = this.select.val(), null === a ? [] : a) : (a = this.opts.element.val(), s(a, this.opts.separator))
			},
			setVal: function(b) {
				var c;
				this.select ? this.select.val(b) : (c = [], a(b).each(function() {
					p(this, c) < 0 && c.push(this)
				}), this.opts.element.val(0 === c.length ? "" : c.join(this.opts.separator)))
			},
			buildChangeDetails: function(a, b) {
				for (var b = b.slice(0), a = a.slice(0), c = 0; c < b.length; c++) for (var d = 0; d < a.length; d++) r(this.opts.id(b[c]), this.opts.id(a[d])) && (b.splice(c, 1), c > 0 && c--, a.splice(d, 1), d--);
				return {
					added: b,
					removed: a
				}
			},
			val: function(c, d) {
				var e, f = this;
				if (0 === arguments.length) return this.getVal();
				if (e = this.data(), e.length || (e = []), !c && 0 !== c) return this.opts.element.val(""), this.updateSelection([]), this.clearSearch(), d && this.triggerChange({
					added: this.data(),
					removed: e
				}), void 0;
				if (this.setVal(c), this.select) this.opts.initSelection(this.select, this.bind(this.updateSelection)), d && this.triggerChange(this.buildChangeDetails(e, this.data()));
				else {
					if (this.opts.initSelection === b) throw new Error("val() cannot be called if initSelection() is not defined");
					this.opts.initSelection(this.opts.element, function(b) {
						var c = a.map(b, f.id);
						f.setVal(c), f.updateSelection(b), f.clearSearch(), d && f.triggerChange(f.buildChangeDetails(e, f.data()))
					})
				}
				this.clearSearch()
			},
			onSortStart: function() {
				if (this.select) throw new Error("Sorting of elements is not supported when attached to <select>. Attach to <input type='hidden'/> instead.");
				this.search.width(0), this.searchContainer.hide()
			},
			onSortEnd: function() {
				var b = [],
					c = this;
				this.searchContainer.show(), this.searchContainer.appendTo(this.searchContainer.parent()), this.resizeSearch(), this.selection.find(".select2-search-choice").each(function() {
					b.push(c.opts.id(a(this).data("select2-data")))
				}), this.setVal(b), this.triggerChange()
			},
			data: function(b, c) {
				var e, f, d = this;
				return 0 === arguments.length ? this.selection.children(".select2-search-choice").map(function() {
					return a(this).data("select2-data")
				}).get() : (f = this.data(), b || (b = []), e = a.map(b, function(a) {
					return d.opts.id(a)
				}), this.setVal(e), this.updateSelection(b), this.clearSearch(), c && this.triggerChange(this.buildChangeDetails(f, this.data())), void 0)
			}
		}), a.fn.select2 = function() {
			var d, e, f, g, h, c = Array.prototype.slice.call(arguments, 0),
				i = ["val", "destroy", "opened", "open", "close", "focus", "isFocused", "container", "dropdown", "onSortStart", "onSortEnd", "enable", "disable", "readonly", "positionDropdown", "data", "search"],
				j = ["opened", "isFocused", "container", "dropdown"],
				k = ["val", "data"],
				l = {
					search: "externalSearch"
				};
			return this.each(function() {
				if (0 === c.length || "object" == typeof c[0]) d = 0 === c.length ? {} : a.extend({}, c[0]), d.element = a(this), "select" === d.element.get(0).tagName.toLowerCase() ? h = d.element.prop("multiple") : (h = d.multiple || !1, "tags" in d && (d.multiple = h = !0)), e = h ? new window.Select2["class"].multi : new window.Select2["class"].single, e.init(d);
				else {
					if ("string" != typeof c[0]) throw "Invalid arguments to select2 plugin: " + c;
					if (p(c[0], i) < 0) throw "Unknown method: " + c[0];
					if (g = b, e = a(this).data("select2"), e === b) return;
					if (f = c[0], "container" === f ? g = e.container : "dropdown" === f ? g = e.dropdown : (l[f] && (f = l[f]), g = e[f].apply(e, c.slice(1))), p(c[0], j) >= 0 || p(c[0], k) >= 0 && 1 == c.length) return !1
				}
			}), g === b ? this : g
		}, a.fn.select2.defaults = {
			width: "copy",
			loadMorePadding: 0,
			closeOnSelect: !0,
			openOnEnter: !0,
			containerCss: {},
			dropdownCss: {},
			containerCssClass: "",
			dropdownCssClass: "",
			formatResult: function(a, b, c, d) {
				var e = [];
				return E(a.text, c.term, e, d), e.join("")
			},
			formatSelection: function(a, c, d) {
				return a ? d(a.text) : b
			},
			sortResults: function(a) {
				return a
			},
			formatResultCssClass: function(a) {
				return a.css
			},
			formatSelectionCssClass: function() {
				return b
			},
			formatMatches: function(a) {
				return 1 === a ? "One result is available, press enter to select it." : a + " results are available, use up and down arrow keys to navigate."
			},
			formatNoMatches: function() {
				return "No matches found"
			},
			formatInputTooShort: function(a, b) {
				var c = b - a.length;
				return "Please enter " + c + " or more character" + (1 == c ? "" : "s")
			},
			formatInputTooLong: function(a, b) {
				var c = a.length - b;
				return "Please delete " + c + " character" + (1 == c ? "" : "s")
			},
			formatSelectionTooBig: function(a) {
				return "You can only select " + a + " item" + (1 == a ? "" : "s")
			},
			formatLoadMore: function() {
				return "Loading more results…"
			},
			formatSearching: function() {
				return "Searching…"
			},
			minimumResultsForSearch: 0,
			minimumInputLength: 0,
			maximumInputLength: null,
			maximumSelectionSize: 0,
			id: function(a) {
				return a == b ? null : a.id
			},
			matcher: function(a, b) {
				return o("" + b).toUpperCase().indexOf(o("" + a).toUpperCase()) >= 0
			},
			separator: ",",
			tokenSeparators: [],
			tokenizer: M,
			escapeMarkup: F,
			blurOnChange: !1,
			selectOnBlur: !1,
			adaptContainerCssClass: function(a) {
				return a
			},
			adaptDropdownCssClass: function() {
				return null
			},
			nextSearchTerm: function() {
				return b
			},
			searchInputPlaceholder: "",
			createSearchChoicePosition: "top",
			shouldFocusInput: function(a) {
				var b = "ontouchstart" in window || navigator.msMaxTouchPoints > 0;
				return b ? a.opts.minimumResultsForSearch < 0 ? !1 : !0 : !0
			}
		}, a.fn.select2.ajaxDefaults = {
			transport: a.ajax,
			params: {
				type: "GET",
				cache: !1,
				dataType: "json"
			}
		}, window.Select2 = {
			query: {
				ajax: G,
				local: H,
				tags: I
			},
			util: {
				debounce: w,
				markMatch: E,
				escapeMarkup: F,
				stripDiacritics: o
			},
			"class": {
				"abstract": d,
				single: e,
				multi: f
			}
		}
	}
}(jQuery);